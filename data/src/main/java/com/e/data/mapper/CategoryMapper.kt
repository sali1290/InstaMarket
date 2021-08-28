package com.e.data.mapper

import com.e.data.entity.remote.Category
import com.e.domain.models.AgentsModel
import com.e.domain.models.CategoryModel
import javax.inject.Inject

class CategoryMapper @Inject constructor(){
    fun toMapper(category: Category): CategoryModel {
        return CategoryModel(
            category.id ?: 0,
            category.changed ?: "",
            category.created ?: "",
            category.desc ?: "",
            category.ids ?: "",
            category.image ?: "",
            category.name ?: "",
            category.sort ?: "",
            category.status ?: "",
            category.uid ?: "",
        )
    }
}