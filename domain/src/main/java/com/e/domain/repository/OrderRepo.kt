package com.e.domain.repository

import com.e.domain.models.OrderModel
import com.e.domain.models.OrderRequestModel

interface OrderRepo {

    suspend fun createOrder(
        categoryId: String,
        serviceId: String,
        quantity: String,
        link: String
    ): OrderRequestModel

    suspend fun getOrders(id: Int): MutableList<OrderModel>

}