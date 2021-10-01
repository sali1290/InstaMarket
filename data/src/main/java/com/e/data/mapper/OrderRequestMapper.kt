package com.e.data.mapper

import com.e.data.entity.OrderRequest
import com.e.domain.models.OrderRequestModel
import javax.inject.Inject

class OrderRequestMapper @Inject constructor(){
    fun toMapper(agents: OrderRequest): OrderRequestModel {
        return OrderRequestModel(
            OrderMapper().toMapper(agents.order!!),
            agents.result ?: true,
            agents.message ?: "",
        )
    }
}