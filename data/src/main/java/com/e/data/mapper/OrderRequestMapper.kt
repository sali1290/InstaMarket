package com.e.data.mapper

import com.e.data.entity.OrderRequest
import com.e.domain.models.OrderRequestModel

class OrderRequestMapper {
    fun toMapper(agents: OrderRequest): OrderRequestModel {
        return OrderRequestModel(
            agents.id ?: 0,
            OrderMapper().toMapper(agents.order!!),
            agents.result ?: true,
            agents.message ?: "",
            ErrorsMapper().toMapper(agents.errors!!)
        )
    }
}