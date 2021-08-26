package com.e.domain.repository

import com.e.data.entity.OrderRequest
import com.e.data.entity.local.Order

interface OrderRepo {

    suspend fun createOrder(
        categoryId: String,
        serviceId: String,
        quantity: String,
        link: String
    ): OrderRequest

    suspend fun getOrders(id: Int): MutableList<Order>

}