package com.e.domain.repository

import com.e.domain.models.BlogModel
import com.e.domain.models.UserModel

interface UserRepo {


    suspend fun updateUser(): UserModel?

    suspend fun getBlogs(): MutableList<BlogModel>

    suspend fun updateUserBankInfo(
        shcart: String?,
        shshaba: String?,
        bankName: String?
    ): Boolean

    suspend fun updateUserInfo(
        firstName: String?,
        lastName: String?,
        email: String?,
        username: String?,
        phone: String?
//        birthday: String?,
//        education: String?,
//        marry: String?,
//        sex: String?,
    ): Boolean

}