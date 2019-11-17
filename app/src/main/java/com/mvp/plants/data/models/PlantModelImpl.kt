package com.mvp.plants.data.models

import androidx.lifecycle.LiveData
import com.mvp.plants.data.vos.FavouritePlantVO
import com.mvp.plants.data.vos.PlantVO

object PlantModelImpl : BaseModel(),PlantModel{

    override fun getFavPlants(onFailure: (String) -> Unit): LiveData<List<PlantVO>> {
       return mDatabase.FavPlantDao().getFavPlantList()
    }

    override fun getFavPlantByPlantId(plantId: String): FavouritePlantVO {
        return mDatabase.FavPlantDao().getFavPlantByPlantId(plantId)
    }

    override fun addFavPlant(favPlantsVo: FavouritePlantVO) {
        mDatabase.FavPlantDao().insertFavPlant(favPlantsVo)
    }

    override fun removeFavPlant(favPlantsVo: FavouritePlantVO) {
        mDatabase.FavPlantDao().removeFavPlant(favPlantsVo)
    }

    override fun getPlants(onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        mDataAgent.getPlants(
            {
                if(mDatabase.arePlantsExistsInDB()){
                    onSuccess(it)
                }else{
                    mDatabase.PlantDao().insertPlants(it)
                    onSuccess(it)
                }

            },{
                onFailure(it)
            }
        )
    }

    override fun getPlantById(plantId: String): PlantVO {
        return mDatabase.PlantDao().getPlantById(plantId)
    }

}