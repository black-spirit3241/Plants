package com.mvp.plants.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mvp.plants.R
import com.mvp.plants.data.vos.PlantVO
import com.mvp.plants.views.viewholders.FavouriteViewHolder

class FavouriteRecyclerAdapter : BaseRecyclerAdapter<FavouriteViewHolder,PlantVO>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.fav_item_layout,parent,false)
        return FavouriteViewHolder(view)
    }

}