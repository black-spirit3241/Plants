package com.mvp.plants.data.vos

import com.google.gson.annotations.SerializedName

data class TipVO(
            @SerializedName("temperature")
             val temperature : String,

            @SerializedName("light")
             val light:String,

            @SerializedName("placement")
             val placement:String){

}