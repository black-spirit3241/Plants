package com.mvp.plants

import android.app.Application
import com.mvp.plants.data.models.PlantModelImpl
import com.mvp.plants.data.models.UserModelImpl

class PlantApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        UserModelImpl.initDatabase(applicationContext)
        PlantModelImpl.initDatabase(applicationContext)
    }
}