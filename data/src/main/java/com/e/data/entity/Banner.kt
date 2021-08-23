package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class Banner(

    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    val id: Int,

    @Json(name = "id")
    val h: String,

    @Json(name = "id")
    val name: String,

    @Json(name = "id")
    val src: String,

    @Json(name = "id")
    val w: String
)