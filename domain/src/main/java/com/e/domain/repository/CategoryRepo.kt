package com.e.domain.repository

import com.e.domain.models.CategoryModel

interface CategoryRepo {

    suspend fun getCategory(): MutableList<CategoryModel>

}