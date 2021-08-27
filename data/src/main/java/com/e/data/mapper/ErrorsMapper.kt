package com.e.data.mapper

import com.e.data.entity.local.Errors
import com.e.data.entity.remote.Service
import com.e.domain.models.ErrorsModel
import com.e.domain.models.ServiceModel

class ErrorsMapper {
    fun toMapper(error: Errors): ErrorsModel {
        return ErrorsModel(
            error.email ?: "",
            error.password ?: ""
        )
    }
}