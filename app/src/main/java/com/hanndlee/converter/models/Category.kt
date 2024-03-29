package com.hanndlee.converter.models

import com.squareup.moshi.Json

data class Category(

    @Json(name = "idCategory") val idCategory: String,
    @Json(name = "strCategory") val strCategory: String,
    @Json(name = "strCategoryThumb") val strCategoryThumb: String,
    @Json(name = "strCategoryDescription") val strCategoryDescription: String
)

