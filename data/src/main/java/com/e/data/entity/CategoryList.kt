package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryList(
    @Json(name = "data")
    val categoryList:MutableList<Category>
)
