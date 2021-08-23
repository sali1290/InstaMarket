package com.e.domain.repository

import com.e.domain.models.OrderModel

interface OrderRepo {

    suspend fun getProduct(): MutableList<OrderModel>

}