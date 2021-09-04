package com.e.data.repository.enterAppDataSource.remote

import com.e.data.entity.Token
import retrofit2.Response


interface EnterAppRemoteDataSource {

    suspend fun loginFromRemote(
        email: String,
        password: String
    ): Response<Token>

    suspend fun registerFromRemote(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String ,
        confirmPassword: String
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