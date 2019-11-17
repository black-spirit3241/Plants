package com.mvp.plants.mvp.views

import com.mvp.plants.data.vos.PlantVO

interface PlantDetailView : BaseView{

    fun btnFavItemClick(message : String)
    fun bindPlantDetail(plant : PlantVO)
}