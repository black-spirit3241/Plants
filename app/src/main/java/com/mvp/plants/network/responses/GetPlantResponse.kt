package com.mvp.plants.network.responses

import com.google.gson.annotations.SerializedName
import com.mvp.plants.data.vos.PlantVO
import com.mvp.plants.utils.RESPONSE_OK

data class GetPlantResponse(
    @SerializedName("message")
     val message:String,

    @SerializedName("code")
     val code :Int,

    @SerializedName("data")
     val data : List<PlantVO>?
) {
    fun isResponseOk():Boolean{
        return code == RESPONSE_OK && data!=null
    }
}