package com.mvp.plants.network

import com.mvp.plants.data.vos.PlantVO
import com.mvp.plants.network.responses.GetPlantResponse
import com.mvp.plants.network.responses.LoginUserResponse
import com.mvp.plants.utils.GET_PLANTS
import com.mvp.plants.utils.LOGIN
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query


interface GetPlantApi {

    @POST(GET_PLANTS)
    fun getPlants() : Call<GetPlantResponse>

    @FormUrlEncoded
    @POST(LOGIN)
    fun loginUser(@Field("email")email:String, @Field("password")password:String):Call<LoginUserResponse>
}