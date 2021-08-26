package com.e.data.dao

import androidx.room.*
import com.e.data.entity.OrderRequest
import com.e.data.entity.local.Order

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrders(orderRequest: Order)

    @Query("DELETE FROM `Order`")
    suspend fun deleteOrders()

    @Query("SELECT * FROM `Order`")
    fun getOrderList(): MutableList<Order>

}