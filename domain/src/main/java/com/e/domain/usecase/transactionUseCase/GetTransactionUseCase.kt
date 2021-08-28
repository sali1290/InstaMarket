package com.e.domain.usecase.transactionUseCase

import com.e.domain.repository.TransactionRepo
import javax.inject.Inject

class GetTransactionUseCase @Inject constructor(private val transactionRepo: TransactionRepo) {

    suspend fun execute(id: String) = transactionRepo.getTransactions(id)

}