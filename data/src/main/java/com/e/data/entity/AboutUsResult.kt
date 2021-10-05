package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AboutUsResult(
    @Json(name = "text")
    val text: String?,

    @Json(name = "result")
    val result: Boolean?
)
