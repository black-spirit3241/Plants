package com.mvp.plants.mvp.presenters

import com.mvp.plants.data.models.PlantModelImpl
import com.mvp.plants.data.vos.FavouritePlantVO
import com.mvp.plants.mvp.views.PlantDetailView

class PlantDetailPresenter : BasePresenter<PlantDetailView>(){

    fun onFavItemClick(plantId : String,status : Boolean){
        var favPlantsVo = FavouritePlantVO(0,plantId)
        if (status){
            PlantModelImpl.addFavPlant(favPlantsVo)
            mView.btnFavItemClick("Add to favourite list!")
        }
        else {
            favPlantsVo = PlantModelImpl.getFavPlantByPlantId(plantId)
            PlantModelImpl.removeFavPlant(favPlantsVo)
            mView.btnFavItemClick("Removed From Favourite List!")
        }
    }

    fun onUIReady(plantId : String){
        val plantVo=PlantModelImpl.getPlantById(plantId)
        mView.bindPlantDetail(plantVo)
    }
}