package com.mvp.plants.data.models

import androidx.lifecycle.LiveData
import com.mvp.plants.data.vos.FavouritePlantVO
import com.mvp.plants.data.vos.PlantVO

interface PlantModel  {

    fun getPlants(
        onSuccess : (List<PlantVO>) -> Unit,
        onFailure : (String) -> Unit
    )

     fun getPlantById(plantId: String): PlantVO

    //Favourite
    fun getFavPlants( onFailure: (String) -> Unit): LiveData<List<PlantVO>>

    fun getFavPlantByPlantId(plantId: String): FavouritePlantVO?

    fun addFavPlant(favPlantsVo: FavouritePlantVO)

    fun removeFavPlant(favPlantsVo: FavouritePlantVO)

}