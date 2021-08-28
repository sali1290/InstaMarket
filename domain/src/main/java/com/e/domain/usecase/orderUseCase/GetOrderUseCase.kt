package com.e.domain.usecase.orderUseCase

import com.e.domain.repository.OrderRepo
import javax.inject.Inject

class GetOrderUseCase @Inject constructor(private val orderRepo: OrderRepo) {

    suspend fun execute(id: Int) = orderRepo.getOrders(id)

}