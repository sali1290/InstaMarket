package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(

    @Json(name = "id")
    var id: Int?,

    @Json(name = "changed")
    var changed: String?,

    @Json(name = "created")
    var created: String?,

    @Json(name = "desc")
    var desc: String?,

    @Json(name = "ids")
    var ids: String?,

    @Json(name = "image")
    var image: Any?,

    @Json(name = "name")
    var name: String?,

    @Json(name = "sort")
    var sort: String?,

    @Json(name = "status")
    var status: String?,

    @Json(name = "uid")
    var uid: String?
)