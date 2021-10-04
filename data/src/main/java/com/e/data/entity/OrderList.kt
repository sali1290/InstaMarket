package com.e.data.entity

import com.e.data.entity.local.Order
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderList(
    @Json(name = "data")
    val orderList: MutableList<Order>
)
