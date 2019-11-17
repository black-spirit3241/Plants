package com.mvp.plants.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvp.plants.views.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<VH : BaseViewHolder<T>,T> : RecyclerView.Adapter<VH>() {

    private var dataList : MutableList<T> = ArrayList()


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.data=dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setNewData(newData : MutableList<T>){
        dataList=newData
        notifyDataSetChanged()
    }
}