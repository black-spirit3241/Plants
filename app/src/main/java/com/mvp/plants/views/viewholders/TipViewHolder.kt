package com.mvp.plants.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mvp.plants.R
import com.mvp.plants.data.vos.TipVO
import kotlinx.android.synthetic.main.tip_item_layout.view.*

class TipViewHolder(itemView: View) : BaseViewHolder<TipVO>(itemView){


    override fun bindData(data: TipVO) {
        if(data.light.isNotEmpty()){
            itemView.card.setBackgroundColor(itemView.resources.getColor(R.color.colorAccent))
            Glide.with(itemView.ivTips)
                .load(R.drawable.ic_light)
                .into(itemView.ivTips)
            itemView.tvTipsTitle.text = "Light"
            itemView.tvTipsDesc.text = data.light

        }else if(data.placement.isNotEmpty()){
            itemView.card.setBackgroundColor(itemView.resources.getColor(R.color.colorPrimary))
            Glide.with(itemView.ivTips)
                .load(R.drawable.temperature)
                .into(itemView.ivTips)
            itemView.tvTipsTitle.text = "Temperature"
            itemView.tvTipsDesc.text = data.temperature

        }else if(data.temperature.isNotEmpty()){
            itemView.card.setBackgroundColor(itemView.resources.getColor(R.color.colorAccent))
            Glide.with(itemView.ivTips)
                .load(R.drawable.ic_light)
                .into(itemView.ivTips)
            itemView.tvTipsTitle.text = "Placement"
            itemView.tvTipsDesc.text = data.placement
        }
    }

}