package com.e.domain.repository

import com.e.domain.models.TransactionModel

interface TransactionRepo {

    suspend fun getTransaction(): MutableList<TransactionModel>

    suspend fun updateTransaction(): MutableList<TransactionModel>

}