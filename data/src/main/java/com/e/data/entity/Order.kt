package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Order(
    @Json(name = "order_id")
    var orderId: Int?,

    @Json(name = "id")
    var id: Int?,

    @Json(name = "ids")
    var ids: String?,

    @Json(name = "type")
    var type: String?,

    @Json(name = "cate_id")
    var cateId: String?,

    @Json(name = "service_id")
    var serviceId: String?,

    @Json(name = "service_type")
    var serviceType: String?,

    @Json(name = "api_provider_id")
    var apiProvider_id: String?,

    @Json(name = "api_service_id")
    var apiServiceId: String?,

    @Json(name = "api_order_id")
    var apiOrderId: String?,

    @Json(name = "uid")
    var uid: String?,

    @Json(name = "link")
    var link: String?,

    @Json(name = "quantity")
    var quantity: String?,

    @Json(name = "usernames")
    var userNames: String?,

    @Json(name = "username")
    var userName: String?,

    @Json(name = "hashtags")
    var hashtags: String?,

    @Json(name = "hashtag")
    var hashtag: String?,

    @Json(name = "media")
    var media: String?,

    @Json(name = "comments")
    var comments: String?,

    @Json(name = "sub_posts")
    var subPosts: String?,

    @Json(name = "sub_min")
    var subMin: String?,

    @Json(name = "sub_max")
    var subMax: String?,

    @Json(name = "sub_delay")
    var subDelay: String?,

    @Json(name = "sub_expiry")
    var subexpiry: String?,

    @Json(name = "sub_response_orders")
    var subResponseOrders: String?,

    @Json(name = "sub_response_posts")
    var subResponsePosts: String?,

    @Json(name = "sub_status")
    var subStatus: String?,

    @Json(name = "charge")
    var charge: String?,

    @Json(name = "status")
    var status: String?,

    @Json(name = "start")
    var start: String?,

    @Json(name = "remains")
    var remains: String?,

    @Json(name = "is_drip_feed")
    var isDripFeed: String?,

    @Json(name = "runs")
    var runs: String?,

    @Json(name = "interval")
    var interval: String?,

    @Json(name = "dripfeed_quantity")
    var dripfeedQuantity: String?,

    @Json(name = "note")
    var note: String?,

    @Json(name = "finish")
    var finish: String?,

    @Json(name = "changed")
    var changed: String?,

    @Json(name = "created")
    var created: String?,

    @Json(name = "api_site")
    var apiSite: String?,

    @Json(name = "formal_charge")
    var formalCharge: String?,

    @Json(name = "profit")
    var profit: String?,

    @Json(name = "return_amount")
    var returnAmount: String?,

    @Json(name = "return_id")
    var returnId: String?,

    @Json(name = "api_response")
    var apiResponse: String?,

    @Json(name = "shamsi_created_at")
    var shamsiDate: String?,

    )