package com.e.data.mapper

import com.e.data.entity.local.Errors
import com.e.data.entity.remote.Service
import com.e.domain.models.ErrorsModel
import com.e.domain.models.ServiceModel
import javax.inject.Inject

class ErrorsMapper @Inject constructor(){
    fun toMapper(error: Errors): ErrorsModel {
        return ErrorsModel(
            error.email ?: listOf(),
            error.password ?: listOf()
        )
    }
}