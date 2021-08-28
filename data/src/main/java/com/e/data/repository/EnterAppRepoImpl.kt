package com.e.data.repository

import com.e.data.entity.Token
import com.e.data.mapper.TokenMapper
import com.e.data.repository.enterAppDataSource.local.EnterAppLocalDataSource
import com.e.data.repository.enterAppDataSource.remote.EnterAppRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.TokenModel
import com.e.domain.repository.EnterAppRepo
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class EnterAppRepoImpl @Inject constructor(
    private val enterAppRemoteDataSource: EnterAppRemoteDataSource,
    private val enterAppLocalDataSource: EnterAppLocalDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val tokenMapper: dagger.Lazy<TokenMapper>
) : EnterAppRepo {

    @Throws(IOException::class)
    override suspend fun login(email: String, password: String): TokenModel {
        lateinit var token: TokenModel
        if (netWorkHelper.isNetworkConnected()) {
            if (enterAppRemoteDataSource.loginFromRemote(email, password).isSuccessful &&
                enterAppRemoteDataSource.loginFromRemote(email, password)
                    .body() != null
            ) {
                val response = enterAppRemoteDataSource.loginFromRemote(email, password)
                token = response.body().let {
                    tokenMapper.get().toMapper(it!!)
                }
                enterAppLocalDataSource.saveTokenFromDB(response.body()!!)
                return token
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun register(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String
    ): TokenModel {
        lateinit var token: TokenModel
        if (netWorkHelper.isNetworkConnected()) {
            if (enterAppRemoteDataSource.registerFromRemote(
                    email, phone, firstName,
                    lastName, username, password
                ).isSuccessful &&
                enterAppRemoteDataSource.registerFromRemote(
                    email, phone, firstName,
                    lastName, username, password
                )
                    .body() != null
            ) {
                val response = enterAppRemoteDataSource.registerFromRemote(
                    email, phone, firstName,
                    lastName, username, password
                )
                token = response.body().let {
                    tokenMapper.get().toMapper(it!!)
                }
                enterAppLocalDataSource.saveTokenFromDB(response.body()!!)
                return token
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    //not complete
    @Throws(IOException::class)
    override suspend fun getUserFromLogin(
        email: String,
        phone: String,
        type: String,
        description: String,
        username: String,
        password: String
    ): String {
        return ""
    }

    @Throws(IOException::class)
    override suspend fun logout(
        email: String,
        phone: String,
        type: String,
        description: String,
        username: String,
        password: String
    ): String {
        lateinit var message: String
        if (netWorkHelper.isNetworkConnected()) {
            if (enterAppRemoteDataSource.logout(
                    email, phone, type,
                    description, username, password
                ).isSuccessful && enterAppRemoteDataSource.logout(
                    email, phone, type,
                    description, username, password
                ).body() != null
            ) {
                message = enterAppRemoteDataSource.logout(
                    email, phone, type,
                    description, username, password
                ).body()!!
                enterAppLocalDataSource.deleteTokenFromDB()
                return message
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }


    }

    override suspend fun getUserToken(): TokenModel {
        lateinit var token: TokenModel
        if (enterAppLocalDataSource.getTokenFromDB().result == true) {
            token = enterAppLocalDataSource.getTokenFromDB().let {
                tokenMapper.get().toMapper(it)
            }
        } else {
            token.result = false
        }
        return token
    }


}