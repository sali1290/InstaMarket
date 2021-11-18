package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ticket(
    @Json(name = "id")
    val id: Int?,

    @Json(name = "changed")
    val changed: String?,

    @Json(name = "created")
    val created: String?,

    @Json(name = "description")
    val description: String?,

    @Json(name = "ids")
    val ids: String?,

    @Json(name = "messages")
    val messages: Errors?,

    @Json(name = "status")
    val status: String?,

    @Json(name = "subject")
    val subject: String?,

    @Json(name = "uid")
    val uid: String?
)