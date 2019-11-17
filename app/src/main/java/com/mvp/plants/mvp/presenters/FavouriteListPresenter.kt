package com.mvp.plants.mvp.presenters

import androidx.lifecycle.Observer
import com.mvp.plants.activities.BaseActivity
import com.mvp.plants.data.models.PlantModelImpl
import com.mvp.plants.mvp.views.FavouriteView

class FavouriteListPresenter : BasePresenter<FavouriteView>() {

    fun onUiReady(activity: BaseActivity) {
        PlantModelImpl.getFavPlants{
            mView.showErrorMessage(it)
        }.observe(activity, Observer {
            if(it.isNullOrEmpty()){
                mView.showErrorMessage("No Favourite Plant Added!")
            }else {
                mView.showImageList(it)
            }
        })
    }
}