package com.mvp.plants.mvp.views

import com.mvp.plants.data.vos.LoginUserVO

interface LoginView :BaseView{
    fun onLoginClick(email:String,password:String)
    fun loginUser()
    fun navigateToPlantActivity()
    fun checkUser()
    fun showErrorMessage(message:String)
}