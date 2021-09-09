package com.e.data.repository.transactionDataSource.remote

import com.e.data.api.TransactionRequest
import com.e.data.entity.TransactionList
import com.e.data.entity.remote.Transaction
import retrofit2.Response

interface TransactionRemoteDataSource {

    suspend fun createTransactionFromRemote(
        amount: String,
        type: String
    ): Response<String>

    suspend fun getUserTransactionFromRemote(
        accessToken: String,
        transactionRequest: TransactionRequest
    ): Response<TransactionList>

}