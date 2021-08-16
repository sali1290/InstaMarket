package com.e.domain.repository

import com.e.domain.models.UserModel

interface UserRepo {

    suspend fun getUser():UserModel?

    suspend fun updateUser():UserModel?

}