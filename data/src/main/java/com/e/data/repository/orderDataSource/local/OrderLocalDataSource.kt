package com.e.data.repository.orderDataSource.local

import com.e.data.entity.local.Order

interface OrderLocalDataSource {

    suspend fun saveOrderFromDB(orderRequest: Order)

    suspend fun deleteOrderFromDB()

    suspend fun getOrderListFromDB(): MutableList<Order>

}