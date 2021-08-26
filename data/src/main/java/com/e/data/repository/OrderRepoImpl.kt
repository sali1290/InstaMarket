package com.e.data.repository

import com.e.data.entity.OrderRequest
import com.e.data.entity.local.Order
import com.e.data.repository.orderDataSource.local.OrderLocalDataSource
import com.e.data.repository.orderDataSource.remote.OrderRemoteDataSource
import com.e.domain.models.OrderModel
import com.e.domain.models.OrderRequestModel
import com.e.domain.repository.OrderRepo
import java.lang.Exception

class OrderRepoImpl(
    private val orderLocalDataSource: OrderLocalDataSource,
    private val orderRemoteDataSource: OrderRemoteDataSource
) : OrderRepo {
    override suspend fun createOrder(
        categoryId: String,
        serviceId: String,
        quantity: String,
        link: String
    ): OrderRequest {

        var order: OrderRequest? = null
        try {
            if (orderRemoteDataSource.createOrderFromRemote(
                    categoryId,
                    serviceId,
                    quantity,
                    link
                ).isSuccessful
            ) {
                order = orderRemoteDataSource.createOrderFromRemote(
                    categoryId,
                    serviceId,
                    quantity,
                    link
                ).body()
                if (order?.result == true) {
                    orderLocalDataSource.saveOrderFromDB(order.order!!)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return order!!
    }

    override suspend fun getOrders(id: Int): MutableList<Order> {

        var orderList: MutableList<Order>? = null

        try {
            if (orderLocalDataSource.getOrderListFromDB().isNotEmpty()) {
                orderList = orderLocalDataSource.getOrderListFromDB()
            } else {
                orderList = orderRemoteDataSource.getOrderListFromRemote(id.toString()).body()
                for (i in 0..orderList?.size!!) {
                    orderLocalDataSource.saveOrderFromDB(orderList[i]!!)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return orderList!!
    }
}