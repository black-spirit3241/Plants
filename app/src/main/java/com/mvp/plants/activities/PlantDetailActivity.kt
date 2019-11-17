package com.mvp.plants.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.mvp.plants.R
import com.mvp.plants.adapters.TipRecyclerAdapter
import com.mvp.plants.data.vos.PlantVO
import com.mvp.plants.data.vos.TipVO
import com.mvp.plants.mvp.presenters.PlantDetailPresenter
import com.mvp.plants.mvp.views.PlantDetailView
import kotlinx.android.synthetic.main.activity_plant_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class PlantDetailActivity : BaseActivity() ,PlantDetailView{

    companion object{
        const val PLANT_ID_EXTRA="plant_id"
        fun newIntent(context: Context,plantId: String): Intent {
            val intent=Intent(context,PlantDetailActivity::class.java)
            intent.putExtra(PLANT_ID_EXTRA,plantId)
            return intent
        }
    }

    lateinit var mPresenter : PlantDetailPresenter
    lateinit var tipAdapter : TipRecyclerAdapter
    private var isFavourite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_detail)
        mPresenter=PlantDetailPresenter()
        mPresenter.initPresenter(this)
        tipAdapter=TipRecyclerAdapter()
        mPresenter.onUIReady(intent.getStringExtra(PLANT_ID_EXTRA))
        setUpListeners(intent.getStringExtra(PLANT_ID_EXTRA))

        with(tipsRecyclerView){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = tipAdapter
        }

    }

    private fun setUpListeners(plantId : String){
        fabLottie.setOnClickListener {
            if(!isFavourite){
                fabLottie.speed=1.0f
                fabLottie.playAnimation()
                isFavourite=true
            }else{
                fabLottie.speed=-4.0f
                fabLottie.playAnimation()
                isFavourite=false
            }

            mPresenter.onFavItemClick(plantId,isFavourite)
        }
    }

    override fun bindPlantDetail(plant: PlantVO) {
        plantName.text=plant.name
        plantUploaderName.text=plant.uploadedUsr.name
        plantDesc.text=plant.description
        Glide.with(ivUploaderPhoto)
            .load(plant.uploadedUsr.user_photo)
            .into(ivUploaderPhoto)
//        mPresenter.onFavItemClick(plant,)

        Glide.with(ivDetailImage)
            .load(plant.plantPhoto)
            .into(ivDetailImage)


        val tips = arrayListOf(
            TipVO("", plant.tips.light, ""),
            TipVO(plant.tips.temperature, "", ""),
            TipVO("", "", plant.tips.placement)
        )
        tipAdapter.setNewData(tips)


    }

    override fun btnFavItemClick(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}
