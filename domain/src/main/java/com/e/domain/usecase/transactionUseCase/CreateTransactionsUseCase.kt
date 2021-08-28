package com.e.domain.usecase.transactionUseCase

import com.e.domain.repository.TransactionRepo
import javax.inject.Inject

class CreateTransactionsUseCase @Inject constructor(private val transactionRepo: TransactionRepo) {

    suspend fun execute(amount: String, type: String) =
        transactionRepo.createTransaction(amount, type)

}