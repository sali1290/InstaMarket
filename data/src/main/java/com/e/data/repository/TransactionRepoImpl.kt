package com.e.data.repository

import com.e.data.mapper.TransactionMapper
import com.e.data.repository.transactionDataSource.remote.TransactionRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.TransactionModel
import com.e.domain.repository.TransactionRepo
import java.io.IOException

class TransactionRepoImpl(
    private val transactionRemoteDataSource: TransactionRemoteDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val transactionMapper: dagger.Lazy<TransactionMapper>
) : TransactionRepo {

    @Throws(IOException::class)
    override suspend fun createTransaction(amount: String, type: String): String {
        lateinit var message: String
        if (netWorkHelper.isNetworkConnected()) {
            if (transactionRemoteDataSource.createTransactionFromRemote(
                    amount,
                    type
                ).isSuccessful &&
                transactionRemoteDataSource.createTransactionFromRemote(amount, type).body() != null
            ) {
                message =
                    transactionRemoteDataSource.createTransactionFromRemote(amount, type).body()
                        .toString()
                return message
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun getTransactions(id: String): MutableList<TransactionModel> {
        lateinit var transactions: MutableList<TransactionModel>
        if (netWorkHelper.isNetworkConnected()) {
            if (transactionRemoteDataSource.getUserTransactionFromRemote(id).isSuccessful &&
                transactionRemoteDataSource.getUserTransactionFromRemote(id).body() != null
            ) {
                val response = transactionRemoteDataSource.getUserTransactionFromRemote(id).body()
                for (i in 0..response?.size!!) {
                    transactions[i] = response[i].let {
                        transactionMapper.get().toMapper(it)
                    }
                }
                return transactions
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }
}