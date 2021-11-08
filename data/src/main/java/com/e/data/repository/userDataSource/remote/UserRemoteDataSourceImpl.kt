package com.e.data.repository.userDataSource.remote

import com.e.data.api.ApiService
import com.e.data.api.UserBankInfoRequest
import com.e.data.entity.BlogList
import com.e.data.entity.Token
import retrofit2.Response
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    UserRemoteDataSource {
    override suspend fun updateUserFromRemote(
        userBankInfoRequest: UserBankInfoRequest
    ): Response<Boolean> {
        return apiService.updateUserBankInfo(userBankInfoRequest)
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