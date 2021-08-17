package com.e.domain.usecase.productUseCase

import com.e.domain.repository.ProductRepo

class GetProductUseCase (private val productRepo: ProductRepo) {

    suspend fun execute() = productRepo.getProduct()

}