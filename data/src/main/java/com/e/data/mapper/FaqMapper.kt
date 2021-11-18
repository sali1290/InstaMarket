package com.e.data.mapper

import com.e.data.entity.Faq
import com.e.domain.models.FaqModel
import javax.inject.Inject

class FaqMapper @Inject constructor(){
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