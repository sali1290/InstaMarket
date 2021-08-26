package com.e.domain.repository

import com.e.data.entity.Transaction
import com.e.domain.models.TransactionModel

interface TransactionRepo {

    suspend fun createTransaction(amount: String, type: String): String?

    suspend fun getTransactions(id:String): MutableList<Transaction>

}