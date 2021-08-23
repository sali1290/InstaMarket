package com.e.data.repository

import com.e.domain.models.OrderModel
import com.e.domain.repository.OrderRepo

class OrderRepoImpl : OrderRepo {
    override suspend fun getProduct(): MutableList<OrderModel> {
        TODO("Not yet implemented")
    }
}