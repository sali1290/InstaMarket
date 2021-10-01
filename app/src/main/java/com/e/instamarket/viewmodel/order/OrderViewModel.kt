package com.e.instamarket.viewmodel.order

import androidx.lifecycle.*
import com.e.domain.models.OrderModel
import com.e.domain.usecase.orderUseCase.CreateOrderUseCase
import com.e.domain.usecase.orderUseCase.GetOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import com.e.domain.Result
import com.e.domain.models.OrderRequestModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

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