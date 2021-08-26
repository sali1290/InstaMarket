package com.e.data.repository

import com.e.domain.models.OrderModel
import com.e.domain.models.OrderRequestModel
import com.e.domain.repository.OrderRepo

class OrderRepoImpl: OrderRepo {
    override suspend fun createOrder(
        categoryId: String,
        serviceId: String,
        quantity: String,
        link: String
    ): OrderRequestModel {
        TODO("Not yet implemented")
    }

    override suspend fun getOrders(id: Int): MutableList<OrderModel> {
        TODO("Not yet implemented")
    }
}