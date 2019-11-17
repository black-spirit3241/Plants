package com.mvp.plants.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PlantTypeConverter {

    @TypeConverter
    fun jsonToPlantType(jsonString:String):List<String>{
        val typeToken=object :TypeToken<List<String>>(){}.type
        return Gson().fromJson(jsonString,typeToken)
    }

    @TypeConverter
    fun plantTypeToJson(plantTypes : List<String>):String{
        return Gson().toJson(plantTypes)
    }
}