package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Errors(
    @Json(name = "email")
    var email : List<String>?,
    @Json(name = "password")
    var password : List<String>?,

    @Json(name = "username")
    var username : List<String>?,
    @Json(name = "phoen")
    var phoen : List<String>?
)
