package com.e.domain.usecase.orderUseCase

import com.e.domain.repository.OrderRepo
import javax.inject.Inject

class CreateOrderUseCase @Inject constructor(private val orderRepo: OrderRepo) {

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