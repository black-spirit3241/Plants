package com.mvp.plants.mvp.presenters

import android.widget.ImageView
import com.mvp.plants.data.models.PlantModelImpl
import com.mvp.plants.data.models.UserModelImpl
import com.mvp.plants.data.vos.FavouritePlantVO
import com.mvp.plants.delegates.PlantItemDelegate
import com.mvp.plants.mvp.views.PlantListView

class PlantListPresenter : BasePresenter<PlantListView>() ,PlantItemDelegate{


    override fun onClickItem(plantId: String,plantImage:ImageView) {
        mView.navigateToDetail(plantId,plantImage)
    }

    val model=PlantModelImpl

    override fun onCreate() {
        super.onCreate()
        model.getPlants({
            mView.showPlantList(it)
        },{
            mView.showErrorMessage(it)
        })
    }

    fun favNavigationClicked(){
        mView.navigateToFavList()
    }

    fun logoutNavigationClicked(){
        UserModelImpl.logout()
        mView.logout()
    }

    override fun onFavClick(plantId: String, status: Boolean) {
        var favPlantsVo = FavouritePlantVO(0,plantId)
        if(status)
            PlantModelImpl.addFavPlant(favPlantsVo)
        else
        {
            favPlantsVo =  PlantModelImpl.getFavPlantByPlantId(plantId)
            PlantModelImpl.removeFavPlant(favPlantsVo)
        }
    }

}