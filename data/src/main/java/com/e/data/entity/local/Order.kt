package com.e.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Order(
    @PrimaryKey(autoGenerate = true)
    @Json(name = "order_id")
    var orderId: Int?,

    @Json(name = "order_id")
    var apiOrderId: String?,

    @Json(name = "apiProvider_id")
    var apiProvider_id: String?,

    @Json(name = "api_response")
    var apiResponse: String?,

    @Json(name = "api_serviceId")
    var apiServiceId: String?,

    @Json(name = "api_site")
    var apiSite: String?,

    @Json(name = "cate_id")
    var cateId: String?,

    @Json(name = "changed")
    var changed: String?,

    @Json(name = "charge")
    var charge: String?,

    @Json(name = "comments")
    var comments: String?,

    @Json(name = "created")
    var created: String?,

    @Json(name = "dripfeed_quantity")
    var dripfeedQuantity: String?,

    @Json(name = "finish")
    var finish: String?,

    @Json(name = "formal_charge")
    var formalCharge: String?,

    @Json(name = "hashtag")
    var hashtag: String?,

    @Json(name = "hashtags")
    var hashtags: String?,

    @Json(name = "id")
    var id: Int?,

    @Json(name = "ids")
    var ids: String?,

    @Json(name = "interval")
    var interval: String?,

    @Json(name = "is_dripFeed")
    var isDripFeed: String?,

    @Json(name = "link")
    var link: String?,

    @Json(name = "media")
    var media: String?,

    @Json(name = "note")
    var note: String?,

    @Json(name = "profit")
    var profit: String?,

    @Json(name = "quantity")
    var quantity: String?,

    @Json(name = "remains")
    var remains: String?,

    @Json(name = "return_amount")
    var returnAmount: String?,

    @Json(name = "return_id")
    var returnId: String?,

    @Json(name = "runs")
    var runs: String?,

    @Json(name = "service_id")
    var serviceId: String?,

    @Json(name = "service_type")
    var serviceType: String?,

    @Json(name = "start")
    var start: String?,

    @Json(name = "status")
    var status: String?,

    @Json(name = "sub_delay")
    var subDelay: String?,

    @Json(name = "subexpiry")
    var subexpiry: String?,

    @Json(name = "sub_max")
    var subMax: String?,

    @Json(name = "sub_min")
    var subMin: String?,

    @Json(name = "sub_posts")
    var subPosts: String?,

    @Json(name = "sub_response_orders")
    var subResponseOrders: String?,

    @Json(name = "sub_response_posts")
    var subResponsePosts: String?,

    @Json(name = "sub_status")
    var subStatus: String?,

    @Json(name = "type")
    var type: String?,

    @Json(name = "uid")
    var uid: String?,

    @Json(name = "user_name")
    var userName: String?,

    @Json(name = "user_names")
    var userNames: String?


)