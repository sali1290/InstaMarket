package com.e.data.mapper

import com.e.data.entity.Order
import com.e.domain.models.OrderModel
import javax.inject.Inject

class OrderMapper @Inject constructor(){
    fun toMapper(agents: Order): OrderModel {
        return OrderModel(
            agents.orderId ?: 0,
            agents.id ?: 0,
            agents.ids ?: "",
            agents.type ?: "",
            agents.cateId ?: "",
            agents.serviceId ?: "",
            agents.serviceType ?: "",
            agents.apiProvider_id ?: "",
            agents.apiServiceId ?: "",
            agents.apiOrderId ?: "",
            agents.uid ?: "",
            agents.link ?: "",
            agents.quantity ?: "",
            agents.userNames ?: "",
            agents.userName ?: "",
            agents.hashtags ?: "",
            agents.hashtag ?: "",
            agents.media ?: "",
            agents.comments ?: "",
            agents.subPosts ?: "",
            agents.subMin ?: "",
            agents.subMax ?: "",
            agents.subDelay ?: "",
            agents.subexpiry ?: "",
            agents.subResponseOrders ?: "",
            agents.subResponsePosts ?: "",
            agents.subStatus ?: "",
            agents.charge ?: "",
            agents.status ?: "",
            agents.start ?: "",
            agents.remains ?: "",
            agents.isDripFeed ?: "",
            agents.runs ?: "",
            agents.interval ?: "",
            agents.dripfeedQuantity ?: "",
            agents.note ?: "",
            agents.finish ?: "",
            agents.changed ?: "",
            agents.created ?: "",
            agents.apiSite ?: "",
            agents.formalCharge ?: "",
            agents.profit ?: "",
            agents.returnAmount ?: "",
            agents.returnId ?: "",
            agents.apiResponse ?: "",
            agents.shamsiDate ?: ""
        )
    }
}