package com.e.domain.repositories

import com.e.domain.models.ProductModel

interface ProductRepo {

    suspend fun getProduct(): MutableList<ProductModel>

}