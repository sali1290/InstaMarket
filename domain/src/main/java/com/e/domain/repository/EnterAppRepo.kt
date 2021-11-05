package com.e.domain.repository

import com.e.domain.models.*

interface EnterAppRepo {

    suspend fun login(
        email: String,
        password: String,
    ): TokenModel

    suspend fun register(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String,
        confirmPassword: String
    ): RegisterResponseModel

    suspend fun getUserFromLogin(): UserModel

    suspend fun logout(
        email: String,
        phone: String,
        type: String,
        description: String,
        username: String,
        password: String
    ): String

    suspend fun getUserToken(): TokenModel
}