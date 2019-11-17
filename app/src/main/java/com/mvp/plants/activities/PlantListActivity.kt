package com.mvp.plants.activities

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.util.DisplayMetrics
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.mvp.plants.R
import com.mvp.plants.adapters.PlantRecyclerAdapter
import com.mvp.plants.data.vos.PlantVO
import com.mvp.plants.delegates.PlantItemDelegate
import com.mvp.plants.mvp.presenters.PlantListPresenter
import com.mvp.plants.mvp.views.PlantListView
import kotlinx.android.synthetic.main.activity_plant_list.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.content_flower_list.*
import kotlinx.android.synthetic.main.plant_list_main.*

class PlantListActivity : BaseActivity(),NavigationView.OnNavigationItemSelectedListener,PlantListView,PlantItemDelegate {

    companion object{
        fun newPlantListIntent(context: Context):Intent{
            return  Intent(context,PlantListActivity::class.java)
        }
    }

    private lateinit var plantAdapter : PlantRecyclerAdapter
    private lateinit var mPresenter: PlantListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTransition()
        setContentView(R.layout.activity_plant_list)

        plantAdapter=PlantRecyclerAdapter(this)
        mPresenter= PlantListPresenter()
        mPresenter.initPresenter(this)
        mPresenter.onCreate()

        setUpPlantListAnimation()

        with(plantList){
            setHasFixedSize(true)
            layoutManager=
                LinearLayoutManager(this@PlantListActivity, LinearLayoutManager.VERTICAL,false)
            adapter= plantAdapter
        }

        setSupportActionBar(plantListToolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            plantListToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        toggle.isDrawerIndicatorEnabled = true

    }


    private fun setUpTransition(){
        with(window){
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val fadeTransition=Fade()
            fadeTransition.interpolator=AccelerateDecelerateInterpolator()
            fadeTransition.duration=500
            enterTransition=fadeTransition
        }
    }

    private fun setUpPlantListAnimation(){
        val displayMatrix = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMatrix)
        val width = displayMatrix.widthPixels

        ObjectAnimator.ofFloat(
            plantList,
            View.TRANSLATION_X,
            width.toFloat(),
            0f
        ).apply {
            duration = 1000L
            start()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_favourite) {
            mPresenter.favNavigationClicked()
        } else if (item.itemId == R.id.nav_logout) {
            mPresenter.logoutNavigationClicked()
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun showPlantList(plantList: List<PlantVO>) {
        plantAdapter.setNewData(plantList as MutableList<PlantVO>)
    }

    override fun navigateToDetail(plantId: String,plantImage : ImageView) {
        val pair = Pair.create(plantImage as View, "tPlantImage")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pair)
        startActivity(PlantDetailActivity.newIntent(this,plantId),options.toBundle())
    }

    override fun onClickItem(plantId: String,plantImage: ImageView) {
        mPresenter.onClickItem(plantId,plantImage)
    }

    override fun showErrorMessage(message: String) {
        showMessage(message)
    }

    override fun logout() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onFavClick(plantId: String, status: Boolean) {
        mPresenter.onFavClick(plantId,status)
    }

    override fun navigateToFavList() {
        //to fav activity
        startActivity(FavouriteListActivity.newIntent(this))
    }
}
