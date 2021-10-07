package com.e.data.repository

import android.util.Log
import com.e.data.api.CreateTransactionConverter
import com.e.data.api.GetTransactionConverter
import com.e.data.api.TransactionRequest
import com.e.data.mapper.TransactionMapper
import com.e.data.repository.transactionDataSource.remote.TransactionRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.TransactionModel
import com.e.domain.repository.TransactionRepo
import java.io.IOException
import javax.inject.Inject

class TransactionRepoImpl @Inject constructor(
    private val transactionRemoteDataSource: TransactionRemoteDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val transactionMapper: dagger.Lazy<TransactionMapper>,
) : TransactionRepo {

    @Throws(IOException::class)
    override suspend fun createTransaction(amount: String, type: String): String {
        lateinit var link: String
        val createTransactionRequest = CreateTransactionConverter().converter(amount, type)
        val request =
            transactionRemoteDataSource.createTransactionFromRemote(createTransactionRequest)
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful && request.body() != null) {
                link = request.body()!!.link.toString()
                return link
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
        val transactionData: TransactionRequest = GetTransactionConverter().converter(id)
        val transactionRequest = transactionRemoteDataSource.getUserTransactionFromRemote(
            transactionData
        )
        if (netWorkHelper.isNetworkConnected()) {
            if (transactionRequest.isSuccessful &&
                transactionRequest.body() != null
            ) {
                val response = transactionRequest.body()
                Log.v("tag", "transactions working")
                transactions = response!!.transactionList.map {
                    transactionMapper.get()!!.toMapper(it)
                }.toMutableList()
                return transactions
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }
}