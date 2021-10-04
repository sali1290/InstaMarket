package com.e.instamarket.viewmodel.order

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.domain.Result
import com.e.domain.models.OrderRequestModel
import com.e.domain.usecase.orderUseCase.CreateOrderUseCase
import com.e.domain.usecase.orderUseCase.GetOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val createOrderUseCase: CreateOrderUseCase,
    private val getOrderUseCase: GetOrderUseCase
) : ViewModel() {

    private val _order = MutableLiveData<Result<OrderRequestModel>>()
    val order: LiveData<Result<OrderRequestModel>>
        get() = _order

    private val orderHandler = CoroutineExceptionHandler { _, exception ->
        _order.postValue(exception.message?.let { Result.Error(it) })
    }

    fun createOrder(categoryId: String, serviceId: String, quantity: String, link: String) =
        viewModelScope.launch(Dispatchers.IO + orderHandler) {
            _order.postValue(Result.Loading)
            createOrderUseCase.execute(categoryId, serviceId, quantity, link).let {
                _order.postValue(Result.Success(it))
            }
        }





}