package com.e.data.entity

import androidx.room.Entity
import com.e.data.entity.localEntity.LuckUser
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Luck(

    @Json(name = "result")
    var result: Boolean?,

    @Json(name = "luck")
    var luck: LuckUser?,

    @Json(name = "message")
    var message: String?,
)
