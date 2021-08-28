package com.e.data.repository.orderDataSource.local

import com.e.data.dao.OrderDao
import com.e.data.entity.OrderRequest
import com.e.data.entity.local.Order
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class OrderLocalDataSourceImpl @Inject constructor(private val orderDao: OrderDao): OrderLocalDataSource {
    override suspend fun saveOrderFromDB(order: Order) {
        CoroutineScope(Dispatchers.IO).launch {
            orderDao.saveOrders(order)
        }
    }

    override suspend fun deleteOrderFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            orderDao.deleteOrders()
        }
    }

    override suspend fun getOrderListFromDB(): MutableList<Order> {
        return orderDao.getOrderList()
        }
}