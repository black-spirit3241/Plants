package com.mvp.plants.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mvp.plants.data.vos.PlantVO
import com.mvp.plants.delegates.PlantItemDelegate
import kotlinx.android.synthetic.main.plant_item_layout.view.*

class PlantItemViewHolder(itemView: View,private val delegate:PlantItemDelegate) : BaseViewHolder<PlantVO>(itemView) {


    init {
        itemView.setOnClickListener{
            data?.plantId?.let {
                delegate.onClickItem(it,itemView.ivPlant)
            }
        }

        itemView.tbFav.setOnClickListener {
            data?.plantId?.let {
                delegate.onFavClick(it,itemView.tbFav.isChecked)
            }
        }
    }


    override fun bindData(data: PlantVO) {
        itemView.tvPlantName.text=data.name
        itemView.tvUserName.text=data.uploadedUsr.name
        Glide.with(itemView.ivPlant)
            .load(data.plantPhoto)
            .into(itemView.ivPlant)

        Glide.with(itemView.ivUploadUser)
            .load(data.uploadedUsr.user_photo)
            .into(itemView.ivUploadUser)
    }



}