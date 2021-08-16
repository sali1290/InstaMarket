package com.e.domain.usecase.transactionUseCase

import com.e.domain.repository.TransactionRepo

class GetTransactionUseCase(private val transactionRepo: TransactionRepo) {

    suspend fun execute() = transactionRepo.getTransaction()

}