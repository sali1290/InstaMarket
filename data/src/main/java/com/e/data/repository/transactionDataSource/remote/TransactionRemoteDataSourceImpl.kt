package com.e.data.repository.transactionDataSource.remote

import com.e.data.api.ApiService
import com.e.data.api.CreateTransactionRequest
import com.e.data.api.TransactionRequest
import com.e.data.entity.TransactionLink
import com.e.data.entity.TransactionList
import retrofit2.Response
import javax.inject.Inject

class TransactionRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    TransactionRemoteDataSource {
    override suspend fun createTransactionFromRemote(
        createTransactionRequest: CreateTransactionRequest
    ): Response<TransactionLink> {
        return apiService.createTransaction(createTransactionRequest)
    }

    override suspend fun getUserTransactionFromRemote(
        transactionRequest: TransactionRequest
    ): Response<TransactionList> {
        return apiService.getUserTransaction(transactionRequest)
    }
}