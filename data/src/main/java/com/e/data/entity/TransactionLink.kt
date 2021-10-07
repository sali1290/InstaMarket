package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransactionLink(

    @Json(name = "link")
    var link: String?,




)
