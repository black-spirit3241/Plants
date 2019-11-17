package com.mvp.plants.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mvp.plants.data.vos.FavouritePlantVO
import com.mvp.plants.data.vos.PlantVO
import kotlinx.android.synthetic.main.fav_item_layout.view.*

class FavouriteViewHolder(itemView : View) : BaseViewHolder<PlantVO>(itemView){
    override fun bindData(data: PlantVO) {
        Glide.with(itemView.ivFavImg)
            .load(data.plantPhoto)
            .into(itemView.ivFavImg)
    }


}