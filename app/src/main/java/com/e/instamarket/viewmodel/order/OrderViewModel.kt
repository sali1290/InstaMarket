package com.e.instamarket.viewmodel.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.e.domain.usecase.orderUseCase.CreateOrderUseCase
import com.e.domain.usecase.orderUseCase.GetOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val createOrderUseCase: CreateOrderUseCase,
    private val getOrderUseCase: GetOrderUseCase
) : ViewModel() {

    fun createOrder(
        categoryId: String,
        serviceId: String,
        quantity: String,
        link: String
    ) = liveData {
        val order = createOrderUseCase.execute(
            categoryId,
            serviceId,
            quantity,
            link
        )
        emit(order)
    }

    fun getOrders(id: Int) = liveData {
        val orderList = getOrderUseCase.execute(id)
        emit(orderList)
    }


}