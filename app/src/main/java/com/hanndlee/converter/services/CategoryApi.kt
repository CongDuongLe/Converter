package com.hanndlee.converter.services

import com.hanndlee.converter.models.ListCategory
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
     @GET("categories.php") // categories.php is endpoint
        suspend fun getCategories(): Response<ListCategory>

}