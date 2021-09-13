package com.e.data.repository

import com.e.data.api.LoginRequest
import com.e.data.api.LoginTypeConverter
import com.e.data.api.RegisterRequest
import com.e.data.api.RegisterTypeConverter
import com.e.data.mapper.TokenMapper
import com.e.data.repository.enterAppDataSource.local.EnterAppLocalDataSource
import com.e.data.repository.enterAppDataSource.remote.EnterAppRemoteDataSource
import com.e.data.repository.userDataSource.local.UserLocalDataSource
import com.e.data.utile.NetWorkHelper
import com.e.data.utile.SessionManager
import com.e.domain.models.TokenModel
import com.e.domain.repository.EnterAppRepo
import java.io.IOException
import javax.inject.Inject

class EnterAppRepoImpl @Inject constructor(
    private val enterAppRemoteDataSource: EnterAppRemoteDataSource,
    private val enterAppLocalDataSource: EnterAppLocalDataSource,
    private val userLocalDataSource: UserLocalDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val tokenMapper: dagger.Lazy<TokenMapper>,
    private val sessionManager: SessionManager

) : EnterAppRepo {

    @Throws(IOException::class)
    override suspend fun login(email: String, password: String): TokenModel {
        lateinit var token: TokenModel
        val loginRequest: LoginRequest = LoginTypeConverter().converter(email, password)
        if (netWorkHelper.isNetworkConnected()) {
            if (enterAppRemoteDataSource.loginFromRemote(loginRequest).isSuccessful &&
                enterAppRemoteDataSource.loginFromRemote(loginRequest)
                    .body() != null
            ) {
                val response = enterAppRemoteDataSource.loginFromRemote(loginRequest)
                token = response.body().let {
                    tokenMapper.get().toMapper(it!!)
                }
//                enterAppLocalDataSource.saveTokenFromDB(response.body()!!)
                userLocalDataSource.saveUserFromDB(response.body()?.user!!)
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
        password: String,
        confirmPassword: String
    ): TokenModel {
        lateinit var token: TokenModel
        val registerRequest: RegisterRequest = RegisterTypeConverter().converter(
            email,
            phone,
            firstName,
            lastName,
            username,
            password
        )
        if (netWorkHelper.isNetworkConnected()) {
            if (enterAppRemoteDataSource.registerFromRemote(
                    registerRequest
                ).isSuccessful &&
                enterAppRemoteDataSource.registerFromRemote(
                    registerRequest
                )
                    .body() != null
            ) {
                val response = enterAppRemoteDataSource.registerFromRemote(
                    registerRequest
                )
                token = response.body().let {
                    tokenMapper.get().toMapper(it!!)
                }
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
//                enterAppLocalDataSource.deleteTokenFromDB()
                sessionManager.saveAuthToken("")
                userLocalDataSource.deleteUserFromDB()
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