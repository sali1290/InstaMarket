package com.e.data.repository.userDataSource.remote

import com.e.data.entity.Token
import retrofit2.Response
import retrofit2.http.Field

interface UserRemoteDataSource {

    suspend fun updateUserFromRemote(
        firstName: String,
        lastName: String
    ): Response<Boolean>

    suspend fun checkUserIsVerifyFromRemote(): Response<Boolean>

    suspend fun verifyUserFromRemote(code: String): Response<Token>

    suspend fun sendVerifyFromRemote(): Response<Token>
}