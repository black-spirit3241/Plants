package com.mvp.plants.network.dataagents

import com.mvp.plants.data.vos.PlantVO

interface PlantDataAgent{

    fun getPlants(
        onSuccess : (List<PlantVO>) -> Unit,
        onFailure : (String) -> Unit
    )

}
