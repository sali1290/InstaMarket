package com.e.data.entity.local

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Errors(
    @Json(name = "email")
    var email : String?,
    @Json(name = "password")
    var password : String?
)
