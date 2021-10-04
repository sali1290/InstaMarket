package com.e.data.repository

import com.e.data.mapper.UserMapper
import com.e.data.repository.userDataSource.local.UserLocalDataSource
import com.e.data.repository.userDataSource.remote.UserRemoteDataSource
import com.e.domain.models.UserModel
import com.e.domain.repository.UserRepo
import java.io.IOException
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource,
    private val userMapper: dagger.Lazy<UserMapper>
) :
    UserRepo {

    @Throws(IOException::class)
    override suspend fun getUser(): UserModel {
        lateinit var user: UserModel
        if(userLocalDataSource.getUserFromDB().id != null){
             userLocalDataSource.getUserFromDB().let {
                user = userMapper.get().toMapper(it)
            }
            return user
        }else{
            throw IOException("Sorry!!")
        }


    }

    override suspend fun updateUser(): UserModel? {
        val user: UserModel? = null
        return user!!
    }
}