package com.e.data.entity

import com.e.data.entity.remote.LuckSlice
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LuckSliceList(
    @Json(name = "data")
    val luckSliceList: MutableList<LuckSlice>)
