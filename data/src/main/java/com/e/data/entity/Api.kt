package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class Api(

    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    val id: Int?,

    @Json(name = "balance")
    val balance: String?,

    @Json(name = "changed")
    val changed: String?,

    @Json(name = "created")
    val created: String?,

    @Json(name = "currencyCode")
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