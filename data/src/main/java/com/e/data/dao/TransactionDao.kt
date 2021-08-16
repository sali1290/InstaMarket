package com.e.data.dao

import androidx.room.*

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransaction(transaction: Transaction)

    @Query("SELECT * FROM `Transaction`")
    fun getTransaction() : List<Transaction>

}