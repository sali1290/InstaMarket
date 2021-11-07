package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Blog(
    @Json(name = "id")
    val id: Int?,

    @Json(name = "ids")
    val ids: String?,

    @Json(name = "title")
    val title: String?,

    @Json(name = "file_name")
    val fileName: String?,

    @Json(name = "text")
    val text: String?,

    @Json(name = "status")
    val status: String?,

    @Json(name = "time")
    val time: String?,

    @Json(name = "meta")
    val meta: String?,

    @Json(name = "des")
    val des: String?,

    @Json(name = "category")
    val category: String?,

    @Json(name = "scores")
    val scores: Any?,

    )
