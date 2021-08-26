package com.e.data.repository.orderDataSource.remote

import com.e.data.entity.OrderRequest
import com.e.data.entity.local.Order
import retrofit2.Response


interface OrderRemoteDataSource {

    suspend fun createOrderFromRemote(
        categoryId: String,
        serviceId: String,
        quantity: String,
        link: String
    ): Response<OrderRequest>

    suspend fun getOrderListFromRemote(id: String): Response<MutableList<Order>>

}