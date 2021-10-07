package com.e.data.repository.transactionDataSource.remote

import com.e.data.api.CreateTransactionRequest
import com.e.data.api.TransactionRequest
import com.e.data.entity.TransactionLink
import com.e.data.entity.TransactionList
import retrofit2.Response

interface TransactionRemoteDataSource {

    suspend fun createTransactionFromRemote(
        createTransactionRequest: CreateTransactionRequest
    ): Response<TransactionLink>

    suspend fun getUserTransactionFromRemote(
        transactionRequest: TransactionRequest
    ): Response<TransactionList>

}