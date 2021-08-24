package com.e.data.entity.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LuckSlice(
    var id: Int?,

    @Json(name = "name")
    var name: String?,

    @Json(name = "color")
    var color: String?,

    @Json(name = "value")
    var value: String?

)
