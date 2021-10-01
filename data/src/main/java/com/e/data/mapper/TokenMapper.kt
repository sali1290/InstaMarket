package com.e.data.mapper

import com.e.data.entity.Token
import com.e.domain.models.TokenModel
import javax.inject.Inject

class TokenMapper @Inject constructor() {

    fun toMapper(token: Token): TokenModel {
        return TokenModel(
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