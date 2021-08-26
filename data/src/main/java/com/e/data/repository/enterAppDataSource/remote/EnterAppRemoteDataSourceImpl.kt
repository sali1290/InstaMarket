package com.e.data.repository.enterAppDataSource.remote

import com.e.data.api.ApiService
import com.e.data.entity.Token
import retrofit2.Response

class EnterAppRemoteDataSourceImpl(private val apiService: ApiService) : EnterAppRemoteDataSource {
    override suspend fun loginFromRemote(email: String, password: String): Response<Token> {
        return apiService.login(email, password)
    }

    override suspend fun registerFromRemote(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String
    ): Response<Token> {
        return apiService.register(email, phone, firstName, lastName, username, password)
    }

    override suspend fun getUserFromRemote(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String
    ): Response<String> {
        return apiService.getUser(email, phone, firstName, lastName, username, password)
    }

    override suspend fun logout(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String
    ): Response<String> {
        return apiService.logout(email, phone, firstName, lastName, username, password)
    }
}