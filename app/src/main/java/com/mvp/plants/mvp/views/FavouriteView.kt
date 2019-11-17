package com.mvp.plants.mvp.views

import com.mvp.plants.data.vos.PlantVO

interface FavouriteView :BaseView{
    fun showImageList(plantList : List<PlantVO>)
    fun showErrorMessage(message : String)
}