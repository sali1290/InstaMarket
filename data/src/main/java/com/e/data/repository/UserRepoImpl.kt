package com.e.data.repository

import com.e.data.entity.local.User
import com.e.data.repository.userDataSource.UserRemoteDataSource
import com.e.domain.models.UserModel
import com.e.domain.repository.UserRepo
import java.lang.Exception

class UserRepoImpl(private val userRemoteDataSource: UserRemoteDataSource) : UserRepo {
    override suspend fun getUser(): User? {
        var user: User? = null
//        try{
//            if(userRemoteDataSource.)
//
//
//        }catch (e: Exception){
//            e.printStackTrace()
//        }
        return user!!

    }

    override suspend fun updateUser(): User? {
        var user: User? = null
        return user!!
    }
}