package com.e.data.repository

import com.e.domain.models.CategoryModel
import com.e.domain.repository.CategoryRepo

class CategoryRepoImpl : CategoryRepo {
    override suspend fun getCategory(): MutableList<CategoryModel> {
        TODO("Not yet implemented")
    }
}