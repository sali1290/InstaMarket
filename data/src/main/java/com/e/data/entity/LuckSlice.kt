package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class LuckSlice(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @Json(name = "name")
    var name: String?,

    @Json(name = "color")
    var color: String?,

    @Json(name = "value")
    var value: String?

)
