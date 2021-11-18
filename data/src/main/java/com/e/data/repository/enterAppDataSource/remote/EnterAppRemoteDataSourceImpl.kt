package com.e.data.repository.enterAppDataSource.remote

import com.e.data.api.ApiService
import com.e.data.api.LoginRequest
import com.e.data.api.RegisterRequest
import com.e.data.entity.RegisterResponse
import com.e.data.entity.Token
import com.e.data.entity.User
import retrofit2.Response
import javax.inject.Inject

class EnterAppRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    EnterAppRemoteDataSource {

    override suspend fun loginFromRemote(loginRequest: LoginRequest): Response<Token> {
        return apiService.login(loginRequest)
    }

    override suspend fun registerFromRemote(
        registerRequest: RegisterRequest
    ): Response<RegisterResponse> {
        return apiService.register(registerRequest)
    }

    override suspend fun getUserFromRemote(
    ): Response<User> {
        return apiService.getUser()
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