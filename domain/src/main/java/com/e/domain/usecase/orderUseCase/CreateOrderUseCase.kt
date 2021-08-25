package com.e.domain.usecase.orderUseCase

import com.e.domain.repository.OrderRepo

class CreateOrderUseCase(private val orderRepo: OrderRepo) {

    suspend fun execute(
        categoryId: String,
        serviceId: String,
        quantity: String,
        link: String
    ) = orderRepo.createOrder(
        categoryId,
        serviceId,
        quantity,
        link
    )

}