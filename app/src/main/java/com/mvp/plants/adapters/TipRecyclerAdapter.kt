package com.mvp.plants.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvp.plants.R
import com.mvp.plants.data.vos.TipVO
import com.mvp.plants.views.viewholders.TipViewHolder

class TipRecyclerAdapter : BaseRecyclerAdapter<TipViewHolder,TipVO>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.tip_item_layout,parent,false)
        return TipViewHolder(view)
    }

}