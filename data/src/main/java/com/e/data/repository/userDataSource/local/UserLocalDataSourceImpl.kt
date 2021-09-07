package com.e.data.repository.userDataSource.local

import com.e.data.dao.UserDao
import com.e.data.entity.local.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserLocalDataSourceImpl @Inject constructor(
    private val userDao: UserDao
) : UserLocalDataSource {
    override suspend fun saveUserFromDB(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.saveUser(user)
        }
    }

    override suspend fun getUserFromDB(): User {
        return userDao.getUser()
    }

    override suspend fun deleteUserFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.deleteUser()
        }
    }
}