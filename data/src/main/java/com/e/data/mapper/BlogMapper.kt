package com.e.data.mapper

import com.e.data.entity.Blog
import com.e.domain.models.BlogModel
import javax.inject.Inject

class BlogMapper @Inject constructor() {
    fun toMapper(blog: Blog): BlogModel {
        return BlogModel(
            blog.id ?: 0,
            blog.ids ?: "",
            blog.title ?: "",
            blog.fileName ?: "",
            blog.text ?: "",
            blog.status ?: "",
            blog.time ?: "",
            blog.meta ?: "",
            blog.des ?: "",
            blog.category ?: ""
        )
    }
}