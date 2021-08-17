package com.e.data.repository

import com.e.domain.models.UserModel
import com.e.domain.repository.UserRepo

class UserRepoImpl : UserRepo {
    override suspend fun getUser(): UserModel? {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(): UserModel? {
        TODO("Not yet implemented")
    }
}