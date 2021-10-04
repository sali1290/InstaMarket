package com.e.data.entity

import com.e.data.entity.remote.Site
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SiteList(
    @Json(name = "data")
    val siteList: MutableList<Site>
)
