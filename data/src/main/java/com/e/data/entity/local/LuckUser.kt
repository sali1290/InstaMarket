package com.e.data.entity.local

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class LuckUser(

    @Json(name = "id")
    var id: Int?,

    @Json(name = "coin")
    var coin: String?,

    @Json(name = "date")
    var date: Date?,

    @Json(name = "user_id")
    var user_id: Int?
)
