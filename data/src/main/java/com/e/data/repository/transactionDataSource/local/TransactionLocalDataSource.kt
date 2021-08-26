package com.e.data.repository.transactionDataSource.local

import com.e.data.entity.Transaction

interface TransactionLocalDataSource {

    suspend fun saveTransactionFromDB(transaction: Transaction)

    suspend fun deleteTransactionFromDB()

    suspend fun getTransactionFromDB(): MutableList<Transaction>

}