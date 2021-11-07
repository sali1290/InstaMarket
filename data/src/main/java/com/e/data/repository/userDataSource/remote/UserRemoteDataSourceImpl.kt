package com.e.data.repository.userDataSource.remote

import com.e.data.api.ApiService
import com.e.data.entity.BlogList
import com.e.data.entity.Token
import com.e.data.repository.userDataSource.remote.UserRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    UserRemoteDataSource {
    override suspend fun updateUserFromRemote(
        firstName: String,
        lastName: String
    ): Response<Boolean> {
        return apiService.updateUser(firstName, lastName)
    }

    override suspend fun checkUserIsVerifyFromRemote(): Response<Boolean> {
        return apiService.checkUserIsVerify()
    }

    override suspend fun verifyUserFromRemote(code: String): Response<Token> {
        return apiService.verifyUser(code)
    }

    override suspend fun sendVerifyFromRemote(): Response<Token> {
        return apiService.sendVerify()
    }

    override suspend fun getBlogs(): Response<BlogList> {
        return apiService.getBlogs()
    }
}