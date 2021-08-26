package com.e.domain.repository

import com.e.data.entity.local.User

interface UserRepo {

    suspend fun getUser():User?

    suspend fun updateUser(): User?

}