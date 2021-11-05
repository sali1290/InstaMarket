package com.e.data.mapper

import com.e.data.entity.RegisterResponse
import com.e.domain.models.RegisterResponseModel
import javax.inject.Inject

class RegisterResponseMapper @Inject constructor() {

    fun toMapper(token: RegisterResponse): RegisterResponseModel {
        return RegisterResponseModel(
            token.id ?: 0,
            token.accessToken ?: "",
            token.tokenType ?: "",
            token.expires ?: "",
            UserMapper().toMapper(token.user!!),
            token.result ?: false,
            token.errors?.let { ErrorsMapper().toMapper(it) }
        )
    }
}