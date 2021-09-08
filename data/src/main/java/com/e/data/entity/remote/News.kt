package com.e.data.entity.remote

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class News(
    
    @Json(name = "id")
    val id: Int?,

    @Json(name = "changed")
    val changed: String?,

    @Json(name = "created")
    val created: String?,

    @Json(name = "description")
    val description: String?,

    @Json(name = "expiry")
    val expiry: String?,

    @Json(name = "ids")
    val ids: String?,

    @Json(name = "status")
    val status: String?,

    @Json(name = "type")
    val type: String?,

    @Json(name = "uid")
    val uid: String?
): Parcelable