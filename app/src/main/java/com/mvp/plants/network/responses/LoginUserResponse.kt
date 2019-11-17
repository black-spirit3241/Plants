package com.mvp.plants.network.responses

import com.google.gson.annotations.SerializedName
import com.mvp.plants.data.vos.LoginUserVO

data class LoginUserResponse(
    @SerializedName("message")
    val message:String,

    @SerializedName("code")
    val code : Int,

    @SerializedName("data")
    val data : LoginUserVO?
) {
}