package com.e.data.mapper

import com.e.data.entity.Token
import com.e.data.entity.local.User
import com.e.domain.models.TokenModel
import com.e.domain.models.UserModel
import javax.inject.Inject

class TokenMapper @Inject constructor(){

    fun toMapper(token: Token): TokenModel {
        return TokenModel(
            token.id ,
            token.accessToken,
            token.tokenType,
            token.expires,
            UserMapper().toMapper(token.user!!),
            token.result,
            token.errors?.let { ErrorsMapper().toMapper(it) }
        )
    }



}