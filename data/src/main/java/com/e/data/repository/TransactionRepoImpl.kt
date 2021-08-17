package com.e.data.repository

import com.e.domain.models.TransactionModel
import com.e.domain.repository.TransactionRepo

class TransactionRepoImpl : TransactionRepo {
    override suspend fun getTransaction(): MutableList<TransactionModel> {
        TODO("Not yet implemented")
    }

    override suspend fun updateTransaction(): MutableList<TransactionModel> {
        TODO("Not yet implemented")
    }
}