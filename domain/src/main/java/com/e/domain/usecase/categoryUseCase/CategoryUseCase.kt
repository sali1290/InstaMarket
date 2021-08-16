package com.e.domain.usecase.categoryUseCase

import com.e.domain.repository.CategoryRepo

class CategoryUseCase (private val categoryRepo: CategoryRepo){

    suspend fun execute() = categoryRepo.getCategory()

}