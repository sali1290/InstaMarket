package com.e.data.entity.local

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Errors(
    var email : String?,
    var password : String?
)
