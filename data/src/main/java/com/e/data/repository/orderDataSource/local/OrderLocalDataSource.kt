package com.e.data.repository.orderDataSource.local

import com.e.data.entity.OrderRequest

interface OrderLocalDataSource {

    suspend fun saveOrderFromDB(orderRequest: OrderRequest)

    suspend fun deleteOrderFromDB()

    suspend fun getOrderListFromDB(): MutableList<OrderRequest>

}