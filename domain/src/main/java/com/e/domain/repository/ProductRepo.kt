package com.e.domain.repository

import com.e.domain.models.ProductModel

interface ProductRepo {

    suspend fun getProduct(): MutableList<ProductModel>

}