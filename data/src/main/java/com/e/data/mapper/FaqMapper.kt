package com.e.data.mapper

import com.e.data.entity.remote.Category
import com.e.data.entity.remote.Faq
import com.e.domain.models.CategoryModel
import com.e.domain.models.FaqModel

class FaqMapper {
    fun toMapper(faq: Faq): FaqModel {
        return FaqModel(
            faq.id ?: 0,
            faq.answer ?: "",
            faq.changed ?: "",
            faq.created ?: "",
            faq.ids ?: "",
            faq.question ?: "",
            faq.sort ?: "",
            faq.status ?: "",
            faq.uid ?: "",
        )
    }
}