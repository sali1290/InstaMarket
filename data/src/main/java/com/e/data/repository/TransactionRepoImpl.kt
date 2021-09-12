package com.e.data.repository

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.e.data.api.GetTransactionConverter
import com.e.data.api.TransactionRequest
import com.e.data.mapper.TransactionMapper
import com.e.data.repository.transactionDataSource.remote.TransactionRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.data.utile.SessionManager
import com.e.domain.models.TransactionModel
import com.e.domain.repository.TransactionRepo
import java.io.IOException
import javax.inject.Inject

class TransactionRepoImpl @Inject constructor(
    private val transactionRemoteDataSource: TransactionRemoteDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val transactionMapper: dagger.Lazy<TransactionMapper>,
    private val sessionManager: SessionManager
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
        val accessToken: String = sessionManager.fetchAuthToken()!!
        val transactionRequest: TransactionRequest = GetTransactionConverter().converter("12")
        if (netWorkHelper.isNetworkConnected()) {
            if (transactionRemoteDataSource.getUserTransactionFromRemote(
                    accessToken,
                    "12"
                ).isSuccessful &&
                transactionRemoteDataSource.getUserTransactionFromRemote(
                    accessToken, "12"
                ).body() != null
            ) {
                val response = transactionRemoteDataSource.getUserTransactionFromRemote(
                    accessToken,
                    "12"
                ).body()
                Log.i("tag", response!!.transactionList[2].transactionId.toString())
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