package com.e.data.repository

import com.e.data.entity.local.User
import com.e.data.repository.userDataSource.UserRemoteDataSource
import com.e.domain.models.UserModel
import com.e.domain.repository.UserRepo
import java.lang.Exception
import javax.inject.Inject

class UserRepoImpl @Inject constructor(private val userRemoteDataSource: UserRemoteDataSource) :
    UserRepo {
    override suspend fun getUser(): UserModel? {
        var user: UserModel? = null

        return user!!

    }

    override suspend fun updateUser(): UserModel? {
        var user: UserModel? = null
        return user!!
    }
}