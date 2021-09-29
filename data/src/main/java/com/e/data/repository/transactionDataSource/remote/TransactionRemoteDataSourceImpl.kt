package com.e.data.repository.transactionDataSource.remote

import com.e.data.api.ApiService
import com.e.data.api.TransactionRequest
import com.e.data.entity.TransactionList
import retrofit2.Response
import javax.inject.Inject

class TransactionRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    TransactionRemoteDataSource {
    override suspend fun createTransactionFromRemote(
        amount: String,
        type: String
    ): Response<String> {
        return apiService.createTransaction(amount, type)
    }

    override suspend fun getUserTransactionFromRemote(
        transactionRequest: TransactionRequest
    ): Response<TransactionList> {
        return apiService.getUserTransaction(transactionRequest)
    }
}