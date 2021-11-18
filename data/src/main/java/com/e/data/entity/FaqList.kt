package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FaqList(
    @Json(name = "data")
    val faqList: MutableList<Faq>
)