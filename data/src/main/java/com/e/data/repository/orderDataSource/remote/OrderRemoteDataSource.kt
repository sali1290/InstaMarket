package com.e.data.repository.orderDataSource.remote

import com.e.data.api.OrderRequestConverter
import com.e.data.entity.OrderList
import com.e.data.entity.OrderRequest
import retrofit2.Response


interface OrderRemoteDataSource {

    suspend fun createOrderFromRemote(
        orderRequestConverter: OrderRequestConverter
    ): Response<OrderRequest>

    suspend fun getOrderListFromRemote(id: String): Response<OrderList>

}