package com.e.data.repository

import com.e.data.entity.Transaction
import com.e.data.repository.transactionDataSource.local.TransactionLocalDataSource
import com.e.data.repository.transactionDataSource.remote.TransactionRemoteDataSource
import com.e.domain.models.TransactionModel
import com.e.domain.repository.TransactionRepo
import java.lang.Exception

class TransactionRepoImpl(
    private val transactionRemoteDataSource: TransactionRemoteDataSource,
    private val transactionLocalDataSource: TransactionLocalDataSource
) : TransactionRepo {
    override suspend fun createTransaction(amount: String, type: String): String? {
        var message: String? = ""
        try {
            if (transactionRemoteDataSource.createTransactionFromRemote(
                    amount,
                    type
                ).isSuccessful
            ) {
                message =
                    transactionRemoteDataSource.createTransactionFromRemote(amount, type).body()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return message
    }

    override suspend fun getTransactions(id: String): MutableList<Transaction> {
        var transactions: MutableList<Transaction>? = null
        try {
            if (transactionLocalDataSource.getTransactionFromDB().isNotEmpty()) {
                transactions = transactionLocalDataSource.getTransactionFromDB()
            } else {
                transactions = transactionRemoteDataSource.getUserTransactionFromRemote(id).body()
                for (i in 0..transactions?.size!!) {
                    transactionLocalDataSource.saveTransactionFromDB(transactions[i])
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return transactions!!
    }
}