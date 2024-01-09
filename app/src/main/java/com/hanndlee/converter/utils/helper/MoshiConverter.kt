package com.hanndlee.converter.utils.helper

import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson


@FromJson
fun <T> convertFromJson (json: String, clazz: Class<T>): T? {
    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(clazz).lenient()
    return adapter.fromJson(json)
}

@ToJson
fun <T> convertToJson (data: T, clazz: Class<T>): String? {
    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(clazz).lenient()
    return adapter.toJson(data)
}


