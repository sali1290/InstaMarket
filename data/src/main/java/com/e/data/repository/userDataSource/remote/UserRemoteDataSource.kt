package com.e.data.repository.userDataSource.remote

import com.e.data.api.UserBankInfoRequest
import com.e.data.api.UserInfoRequest
import com.e.data.entity.BlogList
import com.e.data.entity.Token
import retrofit2.Response

interface UserRemoteDataSource {

    suspend fun updateUserBankInfoFromRemote(
        userBankInfoRequest: UserBankInfoRequest
    ): Response<Boolean>

    suspend fun updateUserInfoFromRemote(
        userInfoRequest: UserInfoRequest
    ): Response<Boolean>

    suspend fun checkUserIsVerifyFromRemote(): Response<Boolean>

    suspend fun verifyUserFromRemote(code: String): Response<Token>

    suspend fun sendVerifyFromRemote(): Response<Token>

    suspend fun getBlogs(): Response<BlogList>
}