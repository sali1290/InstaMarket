package com.e.data.repository.userDataSource.local

import com.e.data.entity.local.User

interface UserLocalDataSource {

    suspend fun saveUserFromDB(user: User)

    suspend fun getUserFromDB(): User

    suspend fun deleteUserFromDB()

}