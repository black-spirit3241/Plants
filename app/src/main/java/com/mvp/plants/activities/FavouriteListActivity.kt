package com.mvp.plants.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.OvershootInterpolator
import com.mvp.plants.R
import com.mvp.plants.adapters.FavouriteRecyclerAdapter
import com.mvp.plants.data.vos.PlantVO
import com.mvp.plants.mvp.presenters.FavouriteListPresenter
import com.mvp.plants.mvp.views.FavouriteView
import kotlinx.android.synthetic.main.activity_favourite_list.*

class FavouriteListActivity : BaseActivity(),FavouriteView {

    companion object{
        fun newIntent(context:Context): Intent {
            return Intent(context,FavouriteListActivity::class.java)
        }
    }

    private lateinit var favAdapter: FavouriteRecyclerAdapter
    private lateinit var mPresenter: FavouriteListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTransition()
        setContentView(R.layout.activity_favourite_list)
        favAdapter= FavouriteRecyclerAdapter()
        mPresenter= FavouriteListPresenter()
        mPresenter.initPresenter(this)
        with(rvFavList) {
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
            adapter = favAdapter
        }
        mPresenter.onUiReady(this)

    }

    override fun showImageList(plantList: List<PlantVO>) {
        favAdapter.setNewData(plantList as MutableList<PlantVO>)
    }

    override fun showErrorMessage(message: String) {
        showMessage(message)
    }

    private fun setUpTransition(){
        with(window){
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val animation= Slide()
            animation.interpolator=AccelerateDecelerateInterpolator()
            animation.slideEdge=Gravity.RIGHT
            animation.duration=1000L
            enterTransition=animation
            exitTransition=animation
        }
    }

}
