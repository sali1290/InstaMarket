package com.e.data.repository.orderDataSource.remote

import com.e.data.api.ApiService
import com.e.data.api.OrderRequestConverter
import com.e.data.entity.OrderRequest
import com.e.data.entity.local.Order
import retrofit2.Response
import javax.inject.Inject

class OrderRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) : OrderRemoteDataSource {
    override suspend fun createOrderFromRemote(
        orderRequestConverter: OrderRequestConverter
    ): Response<OrderRequest> {
        return apiService.createOrder( orderRequestConverter)
    }

    override suspend fun getOrderListFromRemote(id: String): Response<MutableList<Order>> {
        return apiService.getUserOrders(id)
    }
}