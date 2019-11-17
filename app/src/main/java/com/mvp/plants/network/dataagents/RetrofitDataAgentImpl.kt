package com.mvp.plants.network.dataagents

import com.mvp.plants.data.vos.LoginUserVO
import com.mvp.plants.data.vos.PlantVO
import com.mvp.plants.network.GetPlantApi
import com.mvp.plants.network.responses.GetPlantResponse
import com.mvp.plants.network.responses.LoginUserResponse
import com.mvp.plants.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgentImpl : PlantDataAgent,LoginDataAgent {


    private var mPlantApi : GetPlantApi

    init {
        val okHttpClient=OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS)
            .build()

        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        mPlantApi=retrofit.create(GetPlantApi::class.java)
    }


    override fun getPlants(onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        val call= mPlantApi.getPlants()
        call.enqueue(object : Callback<GetPlantResponse> {

            override fun onResponse(
                call: Call<GetPlantResponse>,
                response: Response<GetPlantResponse>
            ) {
                val plantResponse=response.body()
                if(plantResponse!=null){
                    plantResponse.data?.let { onSuccess(it) }
                }else{
                    onFailure(response.message())
                }
            }

            override fun onFailure(call: Call<GetPlantResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }
        })

    }

    override fun loginUser(
        email: String,
        password: String,
        onSuccess: (LoginUserVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call= mPlantApi.loginUser(email,password)
        call.enqueue(object : Callback<LoginUserResponse> {

            override fun onResponse(
                call: Call<LoginUserResponse>,
                response: Response<LoginUserResponse>
            ) {
                val userResponse=response.body()
                if(userResponse!=null){
                    userResponse.data?.let(onSuccess)
                }else
                    onFailure(response.message())
            }

            override fun onFailure(call: Call<LoginUserResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }
        })

    }
}


