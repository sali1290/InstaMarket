package com.e.data.repository.transactionDataSource.remote

import com.e.data.entity.remote.Transaction
import retrofit2.Response

interface TransactionRemoteDataSource {

    suspend fun createTransactionFromRemote(
        amount: String,
        type: String
    ): Response<String>

    suspend fun getUserTransactionFromRemote(id: String): Response<MutableList<Transaction>>

}