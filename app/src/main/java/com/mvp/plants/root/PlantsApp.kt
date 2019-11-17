package com.mvp.plants.root

import android.app.Application
import com.mvp.plants.data.models.PlantModelImpl

class PlantsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        PlantModelImpl.initDatabase(applicationContext)

    }
}