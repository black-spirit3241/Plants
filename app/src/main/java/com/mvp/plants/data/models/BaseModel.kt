package com.mvp.plants.data.models

import android.content.Context
import com.mvp.plants.network.dataagents.RetrofitDataAgentImpl
import com.mvp.plants.persistence.PlantDatabase

abstract class BaseModel {
    protected val mDataAgent=RetrofitDataAgentImpl
    protected lateinit var mDatabase:PlantDatabase

    fun initDatabase(context: Context){
        mDatabase=PlantDatabase.getInstance(context)
    }
}