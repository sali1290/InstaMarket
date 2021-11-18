package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Agents(


    @Json(name = "id")
    val id: Int?,

    @Json(name = "day")
    val day: String?,

    @Json(name = "des")
    val des: String?,

    @Json(name = "flag")
    val flag: String?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "num")
    val num: String?,

    @Json(name = "price")
    val price: String?,

    @Json(name = "subject")
    val subject: String?
)