package com.e.data.repository

import com.e.data.mapper.OrderMapper
import com.e.data.mapper.OrderRequestMapper
import com.e.data.repository.orderDataSource.local.OrderLocalDataSource
import com.e.data.repository.orderDataSource.remote.OrderRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.OrderModel
import com.e.domain.models.OrderRequestModel
import com.e.domain.repository.OrderRepo
import java.io.IOException
import javax.inject.Inject

class OrderRepoImpl @Inject constructor(
    private val orderLocalDataSource: OrderLocalDataSource,
    private val orderRemoteDataSource: OrderRemoteDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val orderRequestMapper: dagger.Lazy<OrderRequestMapper>,
    private val orderMapper: dagger.Lazy<OrderMapper>
) : OrderRepo {

    @Throws(IOException::class)
    override suspend fun createOrder(
        categoryId: String,
        serviceId: String,
        quantity: String,
        link: String
    ): OrderRequestModel {
        lateinit var order: OrderRequestModel
        if (netWorkHelper.isNetworkConnected()) {
            if (orderRemoteDataSource.createOrderFromRemote(
                    categoryId, serviceId, quantity, link
                ).isSuccessful && orderRemoteDataSource.createOrderFromRemote(
                    categoryId, serviceId, quantity, link
                ).body() != null
            ) {
                val response = orderRemoteDataSource.createOrderFromRemote(
                    categoryId, serviceId, quantity, link
                ).body()
                order = response.let {
                    orderRequestMapper.get().toMapper(it!!)
                }
                orderLocalDataSource.saveOrderFromDB(response?.order!!)
                return order
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }


    }

    @Throws(IOException::class)
    override suspend fun getOrders(id: Int): MutableList<OrderModel> {
        lateinit var orderList: MutableList<OrderModel>
        if (orderLocalDataSource.getOrderListFromDB().size > 0) {
            for (i in 0..orderLocalDataSource.getOrderListFromDB().size) {
                orderList[i] = orderLocalDataSource.getOrderListFromDB()[i].let {
                    orderMapper.get().toMapper(it)
                }
            }
            return orderList
        } else {
            if (netWorkHelper.isNetworkConnected()) {
                if (orderRemoteDataSource.getOrderListFromRemote(id.toString()).isSuccessful &&
                    orderRemoteDataSource.getOrderListFromRemote(
                        id.toString()
                    ).body() != null
                ) {
                    val response =
                        orderRemoteDataSource.getOrderListFromRemote(id.toString()).body()
                    for (i in 0..response?.size!!) {
                        orderList[i] = response[i].let {
                            orderMapper.get().toMapper(it)
                        }
                    }
                    return orderList
                } else {
                    throw IOException("Server is Not Responding")
                }
            } else {
                throw IOException("No Internet Connection")
            }
        }
    }

}

