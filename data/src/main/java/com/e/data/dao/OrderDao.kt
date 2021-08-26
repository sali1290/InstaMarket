package com.e.data.dao

import androidx.room.*
import com.e.data.entity.OrderRequest

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrders(orderRequest: OrderRequest)

    @Query("DELETE FROM OrderRequest")
    suspend fun deleteOrders()

    @Query("SELECT * FROM OrderRequest")
    fun getOrderList(): MutableList<OrderRequest>

}