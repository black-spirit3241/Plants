package com.mvp.plants.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mvp.plants.data.vos.FavouritePlantVO
import com.mvp.plants.data.vos.PlantVO

@Dao
interface FavPlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertFavPlant(favPlantsVo: FavouritePlantVO)

    @Query("SELECT plants.* FROM plants INNER JOIN fav_plants WHERE plant_id == fav_plant_id")
     fun getFavPlantList(): LiveData<List<PlantVO>>

    @Query("SELECT * FROM fav_plants WHERE fav_plant_id=:plantId")
    fun getFavPlantByPlantId(plantId:String): FavouritePlantVO

    @Delete
    fun removeFavPlant(favPlantsVo: FavouritePlantVO)

}