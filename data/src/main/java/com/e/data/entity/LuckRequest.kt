package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.e.data.entity.local.LuckUser
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class LuckRequest(

    @PrimaryKey(autoGenerate = true)
    @Json(name = "result")
    var result: Boolean?,

    @Json(name = "luck")
    var luck: LuckUser?,

    @Json(name = "message")
    var message: String?,
)
