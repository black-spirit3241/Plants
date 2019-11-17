package com.mvp.plants.mvp.views

import android.widget.ImageView
import com.mvp.plants.data.vos.PlantVO

interface PlantListView : BaseView{

    fun showPlantList(plantList: List<PlantVO>)
    fun navigateToDetail(plantId:String,plantImage : ImageView)
    fun showErrorMessage(message: String)


    fun navigateToFavList()
    fun logout()

}