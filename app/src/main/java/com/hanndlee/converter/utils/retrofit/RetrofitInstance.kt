package com.hanndlee.converter.utils.retrofit

import com.hanndlee.converter.services.ApiInterface
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {
    private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    private val moshi = Moshi.Builder().add(
        KotlinJsonAdapterFactory()
    ).build()

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    }

    val apiService : ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

}


