package com.e.domain.usecase.transactionUseCase

import com.e.domain.repositories.TransactionRepo

class UpdateTransactionUseCase (private val transactionRepo: TransactionRepo){

    suspend fun execute() = transactionRepo.updateTransaction()

}