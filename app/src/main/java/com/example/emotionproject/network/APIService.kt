package com.example.emotionproject.network

import com.example.emotionproject.models.TestModel
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("http://192.168.1.47:5000/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object ServiceAPI {

    val retrofitService: APIService by lazy {
        retrofit.create(APIService::class.java)
    }

}

interface APIService {
    @FormUrlEncoded
    @POST("/test")
    suspend fun sendText(@Field("test") test: String) : TestModel

}
