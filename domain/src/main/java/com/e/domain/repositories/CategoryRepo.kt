package com.e.domain.repositories

import com.e.domain.models.CategoryModel

interface CategoryRepo {

    suspend fun getCategory(): MutableList<CategoryModel>

}