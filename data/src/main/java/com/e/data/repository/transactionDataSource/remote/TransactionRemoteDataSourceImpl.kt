package com.e.data.repository.transactionDataSource.remote

import com.e.data.api.ApiService
import com.e.data.entity.remote.Transaction
import retrofit2.Response
import javax.inject.Inject

class TransactionRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService): TransactionRemoteDataSource {
    override suspend fun createTransactionFromRemote(
        amount: String,
        type: String
    ): Response<String> {
        return apiService.createTransaction(amount , type)
    }

    override suspend fun getUserTransactionFromRemote(id: String): Response<MutableList<Transaction>> {
        return apiService.getUserTransaction(id)
    }
}