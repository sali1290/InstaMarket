package com.e.data.entity

import com.e.data.entity.local.LuckUser
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LuckRequest(

    @Json(name = "result")
    var result: Boolean?,

    @Json(name = "luck")
    var luck: LuckUser?,

    @Json(name = "message")
    var message: String?,
)
