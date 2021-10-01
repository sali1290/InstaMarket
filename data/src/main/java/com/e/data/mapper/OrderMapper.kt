package com.e.data.mapper

import com.e.data.entity.local.Order
import com.e.data.entity.remote.Service
import com.e.domain.models.OrderModel
import com.e.domain.models.ServiceModel
import javax.inject.Inject

class OrderMapper @Inject constructor(){
    fun toMapper(agents: Order): OrderModel {
        return OrderModel(
            agents.id ?: 0,
            agents.apiOrderId ?: "",
            agents.apiProvider_id ?: "",
            agents.apiResponse ?: "",
            agents.apiServiceId ?: "",
            agents.apiSite ?: "",
            agents.cateId ?: "",
            agents.changed ?: "",
            agents.charge ?: 0,
            agents.comments ?: "",
            agents.created ?: "",
            agents.dripfeedQuantity ?: "",
            agents.finish ?: "",
            agents.formalCharge ?: "",
            agents.hashtag ?: "",
            agents.hashtags ?: "",
            agents.id ?: 0,
            agents.ids ?: 0,
            agents.interval ?: "",
            agents.isDripFeed ?: "",
            agents.link ?: "",
            agents.media ?: "",
            agents.note ?: "",
            agents.profit ?: "",
            agents.quantity ?: "",
            agents.remains ?: "",
            agents.returnAmount ?: "",
            agents.returnId ?: "",
            agents.runs ?: "",
            agents.serviceId ?: "",
            agents.serviceType ?: "",
            agents.start ?: "",
            agents.status ?: "",
            agents.subDelay ?: "",
            agents.subexpiry ?: "",
            agents.subMax ?: "",
            agents.subMin ?: "",
            agents.subPosts ?: "",
            agents.subResponseOrders ?: "",
            agents.subResponsePosts ?: "",
            agents.subStatus ?: "",
            agents.type ?: "",
            agents.uid ?: 0,
            agents.userName ?: "",
            agents.userNames ?: ""
        )
    }
}