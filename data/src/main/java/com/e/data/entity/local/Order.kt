package com.e.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Order(
    @PrimaryKey(autoGenerate = true)
    var orderId: Int?,

    var apiOrderId: String?,

    var apiProvider_id: Any?,

    var apiResponse: Any?,

    var apiServiceId: Any?,

    var apiSite: Any?,

    var cateId: String?,

    var changed: Any?,

    var charge: String?,

    var comments: Any?,

    var created: Any?,

    var dripfeedQuantity: String?,

    var finish: Any?,

    var formalCharge: Any?,

    var hashtag: Any?,

    var hashtags: Any?,

    var id: Int?,

    var ids: Any?,

    var interval: String?,

    var isDripFeed: String?,

    var link: String?,

    var media: Any?,

    var note: Any?,

    var profit: Any?,

    var quantity: String?,

    var remains: String?,

    var returnAmount: Any?,

    var returnId: Any?,

    var runs: String?,

    var serviceId: String?,

    var serviceType: String?,

    var start: String?,

    var status: String?,

    var subDelay: Any?,

    var subexpiry: Any?,

    var subMax: Any?,

    var subMin: Any?,

    var subPosts: Any?,

    var subResponseOrders: Any?,

    var subResponsePosts: Any?,

    var subStatus: Any?,

    var type: String?,

    var uid: String?,

    var userName: Any?,

    var userNames: Any?


)