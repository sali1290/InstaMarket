package com.e.data.entity.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Banner(

    @Json(name = "id")
    val id: Int,

    @Json(name = "id")
    val h: String,

    @Json(name = "id")
    val name: String,

    @Json(name = "id")
    val src: String,

    @Json(name = "id")
    val w: String
)