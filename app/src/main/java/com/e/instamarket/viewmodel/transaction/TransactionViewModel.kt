package com.e.instamarket.viewmodel.transaction

import androidx.lifecycle.*
import com.e.domain.models.TransactionModel
import com.e.domain.usecase.transactionUseCase.CreateTransactionsUseCase
import com.e.domain.usecase.transactionUseCase.GetTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import com.e.domain.Result
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val createTransactionsUseCase: CreateTransactionsUseCase,
    private val getTransactionUseCase: GetTransactionUseCase
) : ViewModel() {

    private val _transactionList = MutableLiveData<Result<MutableList<TransactionModel>>>()
    val transactionList: LiveData<Result<MutableList<TransactionModel>>>
        get() = _transactionList

    private val handler = CoroutineExceptionHandler { _, exception ->
        _transactionList.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getTransactions(id: String) = viewModelScope.launch(Dispatchers.IO + handler) {
        _transactionList.postValue(Result.Loading)
        getTransactionUseCase.execute(id).let {
            _transactionList.postValue(Result.Success(it))
        }
    }


    private val _createRequest = MutableLiveData<Result<String>>()
    val createRequest: LiveData<Result<String>>
        get() = _createRequest
    private val createTransactionHandler = CoroutineExceptionHandler { _, exception ->
        _createRequest.postValue(exception.message?.let { Result.Error(it) })
    }

    fun createTransaction(amount: String, type: String) =
        viewModelScope.launch(Dispatchers.IO + createTransactionHandler) {
            _createRequest.postValue(Result.Loading)
            createTransactionsUseCase.execute(amount, type).let {
                _createRequest.postValue(Result.Success(it!!))
            }
        }


}