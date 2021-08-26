package com.e.data.repository.transactionDataSource.local

import com.e.data.dao.TransactionDao
import com.e.data.entity.Transaction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransactionLocalDataSourceImpl(private val transactionDao: TransactionDao) :
    TransactionLocalDataSource {
    override suspend fun saveTransactionFromDB(transaction: Transaction) {
        CoroutineScope(Dispatchers.IO).launch {
            transactionDao.saveTransaction(transaction)
        }
    }

    override suspend fun deleteTransactionFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            transactionDao.deleteTransaction()
        }
    }

    override suspend fun getTransactionFromDB(): MutableList<Transaction> {
        return transactionDao.getTransactionList()
    }
}