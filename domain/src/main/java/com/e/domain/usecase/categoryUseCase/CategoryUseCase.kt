package com.e.domain.usecase.categoryUseCase

import com.e.domain.repositories.CategoryRepo

class CategoryUseCase (private val categoryRepo: CategoryRepo){

    suspend fun execute() = categoryRepo.getCategory()

}