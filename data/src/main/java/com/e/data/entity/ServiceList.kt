package com.e.data.entity

import com.e.data.entity.remote.Service
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServiceList(
    @Json(name = "data")
    val serviceList : MutableList<Service>
)
