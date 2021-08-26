package com.e.data.repository.orderDataSource.local

import com.e.data.dao.OrderDao
import com.e.data.entity.OrderRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrderLocalDataSourceImpl(private val orderDao: OrderDao): OrderLocalDataSource {
    override suspend fun saveOrderFromDB(orderRequest: OrderRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            orderDao.saveOrders(orderRequest)
        }
    }

    override suspend fun deleteOrderFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            orderDao.deleteOrders()
        }
    }

    override suspend fun getOrderListFromDB(): MutableList<OrderRequest> {
        return orderDao.getOrderList()
        }
}