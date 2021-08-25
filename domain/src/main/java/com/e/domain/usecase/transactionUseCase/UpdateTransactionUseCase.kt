package com.e.domain.usecase.transactionUseCase

import com.e.domain.models.TransactionModel
import com.e.domain.repository.TransactionRepo

class UpdateTransactionUseCase(private val transactionRepo: TransactionRepo) {

    suspend fun execute(transactionModel: TransactionModel) =
        transactionRepo.updateTransactions(transactionModel)

}