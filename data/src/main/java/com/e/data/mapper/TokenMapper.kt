package com.e.data.mapper

import com.e.data.entity.Token
import com.e.data.entity.local.User
import com.e.domain.models.TokenModel
import com.e.domain.models.UserModel

class TokenMapper {

    fun toMapper(token: Token): TokenModel {
        return TokenModel(
            token.id ?: 0,
            token.accessToken ?: "",
            token.tokenType ?: "",
            token.expires ?: "",
            UserMapper().toMapper(token.user!!),
            token.result ?: false,
            ErrorsMapper().toMapper(token.errors!!)
        )
    }
}