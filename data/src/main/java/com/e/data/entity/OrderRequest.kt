package com.e.data.entity

import com.e.data.entity.local.Order
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderRequest(

    @Json(name = "order")
    var order: Order?,

    @Json(name = "result")
    var result: Boolean?,

    @Json(name = "message")
    var message: String?,

    )