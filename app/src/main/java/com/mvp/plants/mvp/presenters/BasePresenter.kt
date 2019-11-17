package com.mvp.plants.mvp.presenters

import com.mvp.plants.mvp.views.BaseView

abstract class BasePresenter<T :BaseView> {

    protected lateinit var mView:T

    fun initPresenter(view:T){
        this.mView=view
    }

    open  fun onCreate(){}
    open  fun onStart(){}
    open  fun onResume(){}
    open  fun onPause(){}
    open  fun onStop(){}
    open  fun onDestroy(){}

}