package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiList(
    @Json(name = "data")
    val apiList: MutableList<Api>
)
