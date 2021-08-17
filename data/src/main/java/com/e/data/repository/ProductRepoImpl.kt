package com.e.data.repository

import com.e.domain.models.ProductModel
import com.e.domain.repository.ProductRepo

class ProductRepoImpl : ProductRepo {
    override suspend fun getProduct(): MutableList<ProductModel> {
        TODO("Not yet implemented")
    }
}