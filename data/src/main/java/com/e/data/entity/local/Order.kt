package com.e.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Order(
    @PrimaryKey(autoGenerate = true)
    var orderId: Int?,

    var apiOrderId: String?,

    var apiProvider_id: String?,

    var apiResponse: String?,

    var apiServiceId: String?,

    var apiSite: String?,

    var cateId: String?,

    var changed: String?,

    var charge: String?,

    var comments: String?,

    var created: String?,

    var dripfeedQuantity: String?,

    var finish: String?,

    var formalCharge: String?,

    var hashtag: String?,

    var hashtags: String?,

    var id: Int?,

    var ids: String?,

    var interval: String?,

    var isDripFeed: String?,

    var link: String?,

    var media: String?,

    var note: String?,

    var profit: String?,

    var quantity: String?,

    var remains: String?,

    var returnAmount: String?,

    var returnId: String?,

    var runs: String?,

    var serviceId: String?,

    var serviceType: String?,

    var start: String?,

    var status: String?,

    var subDelay: String?,

    var subexpiry: String?,

    var subMax: String?,

    var subMin: String?,

    var subPosts: String?,

    var subResponseOrders: String?,

    var subResponsePosts: String?,

    var subStatus: String?,

    var type: String?,

    var uid: String?,

    var userName: String?,

    var userNames: String?


)