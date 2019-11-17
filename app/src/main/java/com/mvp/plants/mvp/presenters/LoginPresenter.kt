package com.mvp.plants.mvp.presenters

import com.mvp.plants.data.models.UserModelImpl
import com.mvp.plants.mvp.views.LoginView

class LoginPresenter : BasePresenter<LoginView>() {

    val model=UserModelImpl

    override fun onCreate() {
        super.onCreate()
    }

    fun checkUser(){
        if(model.checkUser()){
            mView.navigateToPlantActivity()
        }
    }


    fun btnLoginClick(email:String,password:String){
        model.loginUser(email,password,{
            mView.loginUser()
        },{
            mView.showErrorMessage(it)
        })
    }

}