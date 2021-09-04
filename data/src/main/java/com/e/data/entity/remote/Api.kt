package com.e.data.entity.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Api(

    @Json(name = "id")
    val id: Int?,

    @Json(name = "balance")
    val balance: String?,

    @Json(name = "changed")
    val changed: String?,

    @Json(name = "created")
    val created: String?,

    @Json(name = "currency_code")
    val currencyCode: String?,

    @Json(name = "description")
    val description: String?,

    @Json(name = "email")
    val email: String?,

    @Json(name = "ids")
    val ids: String?,

    @Json(name = "key")
    val key: String?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "status")
    val status: String?,

    @Json(name = "type")
    val type: Any?,

    @Json(name = "uid")
    val uid: String?,

    @Json(name = "url")
    val url: String?
)