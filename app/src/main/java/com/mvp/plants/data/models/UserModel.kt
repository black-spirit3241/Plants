package com.mvp.plants.data.models

import com.mvp.plants.data.vos.LoginUserVO
import com.mvp.plants.network.responses.LoginUserResponse

interface UserModel {

    fun loginUser(
        email : String,
        password : String,
        onSuccess : (LoginUserVO) -> Unit,
        onFailure : (String) -> Unit
    )

    fun logout()

    fun checkUser() : Boolean

}