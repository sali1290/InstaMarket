package com.e.data.dao

import androidx.room.*

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct()

    @Update
    suspend fun updateProduct()

    @Query("SELECT * FROM Product")
    fun getProduct()

}