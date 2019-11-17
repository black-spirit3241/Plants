package com.mvp.plants.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mvp.plants.data.vos.FavouritePlantVO
import com.mvp.plants.data.vos.LoginUserVO
import com.mvp.plants.data.vos.PlantVO
import com.mvp.plants.persistence.daos.FavPlantDao
import com.mvp.plants.persistence.daos.PlantDao
import com.mvp.plants.persistence.daos.UserDao
import com.mvp.plants.persistence.typeconverters.PlantTypeConverter
import com.mvp.plants.persistence.typeconverters.TipListTypeConverter
import com.mvp.plants.utils.DB_NAME

@Database(entities = [PlantVO::class,LoginUserVO::class,FavouritePlantVO::class],version = 7,exportSchema = false)
@TypeConverters(PlantTypeConverter::class)
abstract class PlantDatabase : RoomDatabase() {

    companion object{
        private var instance : PlantDatabase?=null

        fun getInstance(context:Context):PlantDatabase{
            if(instance==null){
                instance=Room.databaseBuilder(context,PlantDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as PlantDatabase
        }
    }

    abstract fun PlantDao() : PlantDao

    abstract fun UserDao() : UserDao

    abstract fun FavPlantDao() : FavPlantDao

    fun arePlantsExistsInDB():Boolean{
        return !PlantDao().getPlantList().isEmpty()
    }

    fun areUserLogin():Boolean{
        return UserDao().getUser() != null
    }
}