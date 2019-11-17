package com.mvp.plants.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvp.plants.R
import com.mvp.plants.data.vos.PlantVO
import com.mvp.plants.delegates.PlantItemDelegate
import com.mvp.plants.views.viewholders.PlantItemViewHolder

class PlantRecyclerAdapter(private val delegate:PlantItemDelegate) : BaseRecyclerAdapter<PlantItemViewHolder,PlantVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantItemViewHolder {
        var  view : View = LayoutInflater.from(parent.context).inflate(R.layout.plant_item_layout,parent,false)
        return PlantItemViewHolder(view,delegate)
    }
}