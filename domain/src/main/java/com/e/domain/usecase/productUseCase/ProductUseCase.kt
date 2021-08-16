package com.e.domain.usecase.productUseCase

import com.e.domain.repositories.ProductRepo

class ProductUseCase (private val productRepo: ProductRepo) {

    suspend fun execute() = productRepo.getProduct()

}