package com.mvp.plants.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mvp.plants.data.vos.TipVO
import java.lang.reflect.Type

class TipListTypeConverter {

    @TypeConverter
    fun tipListToJson(tipList : List<TipVO>):String{
        return Gson().toJson(tipList,TipVO::class.java)
    }

    @TypeConverter
    fun jsonToTipList(jsonString : String): List<TipVO>{
        val type=object :TypeToken<List<TipVO>>(){}.type
        return  Gson().fromJson(jsonString,type)
    }
}