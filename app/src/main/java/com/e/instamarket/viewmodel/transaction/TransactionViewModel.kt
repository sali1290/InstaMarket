package com.e.instamarket.viewmodel.transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.e.domain.usecase.transactionUseCase.CreateTransactionsUseCase
import com.e.domain.usecase.transactionUseCase.GetTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val createTransactionsUseCase: CreateTransactionsUseCase,
    private val getTransactionUseCase: GetTransactionUseCase
) : ViewModel() {
    fun createTransaction(amount: String, type: String) = liveData {
        val transaction = createTransactionsUseCase.execute(amount, type)
        emit(transaction)
    }

    fun getTransactions(id: String) = liveData {
        val transactionList = getTransactionUseCase.execute(id)
        emit(transactionList)
    }


}