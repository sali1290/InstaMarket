package com.e.data.repository

import com.e.domain.models.TokenModel
import com.e.domain.repository.EnterAppRepo

class EnterAppRepoImpl: EnterAppRepo {
    override suspend fun login(email: String, password: String): TokenModel {
        TODO("Not yet implemented")
    }

    override suspend fun register(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String
    ): TokenModel {
        TODO("Not yet implemented")
    }

    override suspend fun getUserFromLogin(
        email: String,
        phone: String,
        type: String,
        description: String,
        username: String,
        password: String
    ): String {
        TODO("Not yet implemented")
    }

    override suspend fun logout(
        email: String,
        phone: String,
        type: String,
        description: String,
        username: String,
        password: String
    ): String {
        TODO("Not yet implemented")
    }
}