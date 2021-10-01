package com.e.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class OrderTypeConverter {
    fun converter(
        categoryId: String,
        serviceId: String,
        quantity: String,
        link: String
    ): OrderRequestConverter {
        return OrderRequestConverter(categoryId, serviceId, quantity, link)
    }


}

@JsonClass(generateAdapter = true)
data class OrderRequestConverter(
    @Json(name = "category_id")
    var categoryId: String?,

    @Json(name = "service_id")
    var serviceId: String?,

    @Json(name = "quantity")
    var quantity: String?,

    @Json(name = "link")
    var link: String?
)