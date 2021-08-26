package com.e.data.repository

import com.e.domain.models.TransactionModel
import com.e.domain.repository.TransactionRepo

class TransactionRepoImpl: TransactionRepo {
    override suspend fun createTransaction(amount: String, type: String): String? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTransactions(transactionModel: TransactionModel) {
        TODO("Not yet implemented")
    }

    override suspend fun getTransactions(id: String): MutableList<TransactionModel> {
        TODO("Not yet implemented")
    }
}