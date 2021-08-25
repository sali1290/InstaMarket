package com.e.domain.usecase.transactionUseCase

import com.e.domain.repository.TransactionRepo

class CreateTransactionsUseCase(private val transactionRepo: TransactionRepo) {

    suspend fun execute(amount: String, type: String) =
        transactionRepo.createTransaction(amount, type)

}