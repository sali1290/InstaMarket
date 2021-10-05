package com.e.data.entity.local

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LuckUser(

    @Json(name = "date")
    var date: String?,

    @Json(name = "coin")
    var coin: String?,

    @Json(name = "id")
    var id: Int?,

    @Json(name = "uid")
    var uid: Int?


)
