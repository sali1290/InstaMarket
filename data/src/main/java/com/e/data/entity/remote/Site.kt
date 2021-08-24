package com.e.data.entity.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Site(

    @Json(name = "day")
    var day: String?,

    @Json(name = "des")
    var des: String?,

    @Json(name = "flag")
    var flag: String?,

    @Json(name = "id")
    var id: Int?,

    @Json(name = "name")
    var name: String?,

    @Json(name = "num")
    var num: String?,

    @Json(name = "permition")
    var permition: String?,

    @Json(name = "price")
    var price: String?,

    @Json(name = "subject")
    var subject: String?

)