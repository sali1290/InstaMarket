package com.e.data.entity.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Service(

    val id: Int?,

    val addType: String?,

    val agentprice: String?,

    val apiProviderId: String?,

    val apiServiceId: String?,

    val cateId: String?,

    val changed: String?,

    val created: String?,

    val desc: String?,

    val dripfeed: String?,

    val ids: String?,

    val max: String?,

    val min: String?,

    val name: String?,

    val oagentprice: String?,

    val originalPrice: String?,

    val price: String?,

    val product_type: String?,

    val sortService: String?,

    val status: String?,

    val type: String?,

    val uid: String?

)