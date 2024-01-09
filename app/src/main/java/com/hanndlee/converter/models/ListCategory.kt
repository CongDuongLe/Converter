package com.hanndlee.converter.models

import com.squareup.moshi.Json


data class ListCategory(
    @Json(name="categories")
    val categories: List<Category>
)

