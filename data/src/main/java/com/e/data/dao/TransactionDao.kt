package com.e.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.e.data.entity.Transaction

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTransaction(transaction: Transaction)

    @Query("DELETE FROM `Transaction`")
    suspend fun deleteTransaction()

    @Query("SELECT * FROM `Transaction`")
    suspend fun getTransactionList(): MutableList<Transaction>

}