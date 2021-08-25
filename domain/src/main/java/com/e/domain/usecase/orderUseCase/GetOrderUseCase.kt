package com.e.domain.usecase.orderUseCase

import com.e.domain.repository.OrderRepo

class GetOrderUseCase(private val orderRepo: OrderRepo) {

    suspend fun execute(id: Int) = orderRepo.getOrders(id)

}