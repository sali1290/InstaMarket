package com.e.data.entity.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Service(

    @Json(name = "id")
    val id: Int?,

    @Json(name = "add_type")
    val addType: String?,

    @Json(name = "agentprice")
    val agentprice: String?,

    @Json(name = "api_provider_id")
    val apiProviderId: String?,

    @Json(name = "api_service_id")
    val apiServiceId: String?,

    @Json(name = "cate_id")
    val cateId: String?,

    @Json(name = "changed")
    val changed: String?,

    @Json(name = "created")
    val created: String?,

    @Json(name = "desc")
    val desc: String?,

    @Json(name = "dripfeed")
    val dripfeed: String?,

    @Json(name = "ids")
    val ids: String?,

    @Json(name = "max")
    val max: String?,

    @Json(name = "min")
    val min: String?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "oagentprice")
    val oagentprice: String?,

    @Json(name = "original_price")
    val originalPrice: String?,

    @Json(name = "price")
    val price: String?,

    @Json(name = "product_type")
    val product_type: String?,

    @Json(name = "sort_service")
    val sortService: String?,

    @Json(name = "")
    val status: String?,

    @Json(name = "type")
    val type: String?,

    @Json(name = "uid")
    val uid: String?

)