package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BlogList(
    @Json(name = "data")
    var blogListL: MutableList<Blog>
)
