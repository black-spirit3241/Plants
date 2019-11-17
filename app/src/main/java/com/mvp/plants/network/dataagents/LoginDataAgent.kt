package com.mvp.plants.network.dataagents

import com.mvp.plants.data.vos.LoginUserVO

interface LoginDataAgent {

    fun loginUser(
        email : String,
        password : String,
        onSuccess : (LoginUserVO) -> Unit,
        onFailure : (String) -> Unit
    )
}