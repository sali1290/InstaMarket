package com.e.data.repository

import com.e.data.api.OrderTypeConverter
import com.e.data.mapper.OrderMapper
import com.e.data.mapper.OrderRequestMapper
import com.e.data.repository.orderDataSource.remote.OrderRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.OrderModel
import com.e.domain.models.OrderRequestModel
import com.e.domain.repository.OrderRepo
import java.io.IOException
import javax.inject.Inject

class OrderRepoImpl @Inject constructor(
    private val orderRemoteDataSource: OrderRemoteDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val orderRequestMapper: dagger.Lazy<OrderRequestMapper>,
    private val orderMapper: dagger.Lazy<OrderMapper>,
) : OrderRepo {

    @Throws(IOException::class)
    override suspend fun createOrder(
        categoryId: String,
        serviceId: String,
        quantity: String,
        link: String
    ): OrderRequestModel {
        lateinit var order: OrderRequestModel
        val orderConverted = OrderTypeConverter().converter(categoryId, serviceId, quantity, link)
        val request = orderRemoteDataSource.createOrderFromRemote(orderConverted)
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful && request.body() != null) {
                val response = request.body()
                order = response.let {
                    orderRequestMapper.get().toMapper(it!!)
                }
//                orderLocalDataSource.saveOrderFromDB(response!!)
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
        val request = orderRemoteDataSource.getOrderListFromRemote(id.toString())
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful &&
                request.body() != null
            ) {
                val response = request.body()
                orderList = response!!.orderList.map {
                    orderMapper.get().toMapper(it)
                }.toMutableList()
                return orderList
            } else {
                throw IOException("Server is Not Responding")
            }

        } else {
            throw IOException("No Internet Connection")
        }
    }


}

