package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BannerList(

    @Json(name = "data")
    val bannerList: MutableList<Banner>

)