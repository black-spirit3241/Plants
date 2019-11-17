package com.mvp.plants.delegates

import android.widget.ImageView

interface PlantItemDelegate {
    fun onClickItem(plantId:String,plantImage: ImageView)
    fun onFavClick(plantId:String,status : Boolean)
}