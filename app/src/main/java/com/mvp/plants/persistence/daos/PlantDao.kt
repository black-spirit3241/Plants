package com.mvp.plants.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mvp.plants.data.vos.PlantVO

@Dao
interface PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlants(plantList : List<PlantVO>) : LongArray

    @Query("select * from plants")
    fun getPlantList():List<PlantVO>

    @Query("select * from plants where plant_id=:plantId")
    fun getPlantById(plantId:String):PlantVO
}