package com.e.data.dao

import androidx.room.*

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct()

    @Update
    suspend fun updateProduct()

    @Query("SELECT * FROM `Order`")
    fun getProduct()

}