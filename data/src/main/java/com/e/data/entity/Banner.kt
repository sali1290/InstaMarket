package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Banner(

    @Json(name = "id")
    val id: Int,

    @Json(name = "w")
    val w: String,

    @Json(name = "h")
    val h: String,

    @Json(name = "name")
    val name: String,

    @Json(name = "src")
    val src: String


)