package com.e.domain.usecase.transactionUseCase

import com.e.domain.repositories.TransactionRepo

class GetTransactionUseCase(private val transactionRepo: TransactionRepo) {

    suspend fun execute() = transactionRepo.getTransaction()

}