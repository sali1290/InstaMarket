package com.e.data.repository.enterAppDataSource.remote

import com.e.data.api.LoginRequest
import com.e.data.api.RegisterRequest
import com.e.data.entity.Token
import retrofit2.Response


interface EnterAppRemoteDataSource {

    suspend fun loginFromRemote(
        loginRequest: LoginRequest
    ): Response<Token>

    suspend fun registerFromRemote(
        registerRequest: RegisterRequest
    ): Response<Token>

    suspend fun getUserFromRemote(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String
    ): Response<String>

    suspend fun logout(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String
    ): Response<String>

}