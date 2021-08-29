package com.e.data.db

import androidx.room.TypeConverter
import com.e.data.entity.local.Order
import org.json.JSONObject

class OrderTypeConverter {
    @TypeConverter
    fun fromOrder(order: Order): String {
        return JSONObject().apply {
            put("orderId", order.orderId)
            put("apiOrderId", order.apiOrderId)
            put("apiProvider_id", order.apiProvider_id)
            put("apiResponse", order.apiResponse)
            put("apiServiceId", order.apiServiceId)
            put("apiSite", order.apiSite)
            put("cateId", order.cateId)
            put("changed", order.changed)
            put("charge", order.charge)
            put("comments", order.comments)
            put("created", order.created)
            put("dripfeedQuantity", order.dripfeedQuantity)
            put("finish", order.finish)
            put("formalCharge", order.formalCharge)
            put("hashtag", order.hashtag)
            put("hashtags", order.hashtags)
            put("id", order.id)
            put("ids", order.ids)
            put("interval", order.interval)
            put("isDripFeed", order.isDripFeed)
            put("link", order.link)
            put("media", order.media)
            put("note", order.note)
            put("profit", order.profit)
            put("quantity", order.quantity)
            put("remains", order.remains)
            put("returnAmount", order.returnAmount)
            put("returnId", order.returnId)
            put("runs", order.runs)
            put("serviceId", order.serviceId)
            put("serviceType", order.serviceType)
            put("start", order.start)
            put("status", order.status)
            put("subDelay", order.subDelay)
            put("subexpiry", order.subexpiry)
            put("subMax", order.subMax)
            put("subMin", order.subMin)
            put("subPosts", order.subPosts)
            put("subResponseOrders", order.subResponseOrders)
            put("subResponsePosts", order.subResponsePosts)
            put("subStatus", order.subStatus)
            put("type", order.type)
            put("uid", order.uid)
            put("userName", order.userName)
            put("userNames", order.userNames)
        }.toString()
    }

    @TypeConverter
    fun toOrder(user: String): Order {
        val json = JSONObject(user)
        return Order(
            json.getInt("orderId"),
            json.getString("apiOrderId"),
            json.getString("apiProvider_id"),
            json.getString("apiResponse"),
            json.getString("apiServiceId"),
            json.getString("apiSite"),
            json.getString("cateId"),
            json.getString("changed"),
            json.getString("charge"),
            json.getString("comments"),
            json.getString("created"),
            json.getString("dripfeedQuantity"),
            json.getString("finish"),
            json.getString("formalCharge"),
            json.getString("hashtag"),
            json.getString("hashtags"),
            json.getInt("id"),
            json.getString("ids"),
            json.getString("interval"),
            json.getString("isDripFeed"),
            json.getString("link"),
            json.getString("media"),
            json.getString("note"),
            json.getString("profit"),
            json.getString("quantity"),
            json.getString("remains"),
            json.getString("returnAmount"),
            json.getString("returnId"),
            json.getString("runs"),
            json.getString("serviceId"),
            json.getString("serviceType"),
            json.getString("start"),
            json.getString("status"),
            json.getString("subDelay"),
            json.getString("subexpiry"),
            json.getString("subMax"),
            json.getString("subMin"),
            json.getString("subPosts"),
            json.getString("subResponseOrders"),
            json.getString("subResponsePosts"),
            json.getString("subStatus"),
            json.getString("type"),
            json.getString("uid"),
            json.getString("userName"),
            json.getString("userNames")
        )
    }
}