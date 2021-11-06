package com.e.data.repository

import com.e.data.api.LoginRequest
import com.e.data.api.LoginTypeConverter
import com.e.data.api.RegisterRequest
import com.e.data.api.RegisterTypeConverter
import com.e.data.mapper.RegisterResponseMapper
import com.e.data.mapper.TokenMapper
import com.e.data.mapper.UserMapper
import com.e.data.repository.enterAppDataSource.local.EnterAppLocalDataSource
import com.e.data.repository.enterAppDataSource.remote.EnterAppRemoteDataSource
import com.e.data.repository.userDataSource.local.UserLocalDataSource
import com.e.data.utile.NetWorkHelper
import com.e.data.utile.SessionManager
import com.e.domain.models.RegisterResponseModel
import com.e.domain.models.TokenModel
import com.e.domain.models.UserModel
import com.e.domain.repository.EnterAppRepo
import java.io.IOException
import javax.inject.Inject

class EnterAppRepoImpl @Inject constructor(
    private val enterAppRemoteDataSource: EnterAppRemoteDataSource,
    private val enterAppLocalDataSource: EnterAppLocalDataSource,
    private val userLocalDataSource: UserLocalDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val tokenMapper: dagger.Lazy<TokenMapper>,
    private val userMapper: dagger.Lazy<UserMapper>,
    private val registerResponseMapper: dagger.Lazy<RegisterResponseMapper>,
    private val sessionManager: SessionManager

) : EnterAppRepo {

    @Throws(IOException::class)
    override suspend fun login(email: String, password: String): TokenModel {
        lateinit var token: TokenModel
        val loginRequest: LoginRequest = LoginTypeConverter().converter(email, password)
        val request = enterAppRemoteDataSource.loginFromRemote(loginRequest)
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful &&
                request
                    .body() != null
            ) {
                token = request.body().let {
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

    @Throws(IOException::class)
    override suspend fun register(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String,
        confirmPassword: String
    ): RegisterResponseModel {
        lateinit var token: RegisterResponseModel
        val registerRequest: RegisterRequest = RegisterTypeConverter().converter(
            email,
            phone,
            firstName,
            lastName,
            username,
            password,
            confirmPassword
        )
        val request = enterAppRemoteDataSource.registerFromRemote(registerRequest)
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful &&
                request.body() != null
            ) {

                token = request.body().let {
                    registerResponseMapper.get().toMapper(it!!)
                }
                return token
            } else {
                throw IOException("لطفا دوباره امتحان کنید")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    //not complete
    @Throws(IOException::class)
    override suspend fun getUserFromLogin(): UserModel {
        lateinit var user: UserModel
        val request = enterAppRemoteDataSource.getUserFromRemote()
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful && request.body() != null) {
                val response = request.body()
                user = response.let {
                    userMapper.get().toMapper(it!!)
                }
                userLocalDataSource.saveUserFromDB(response!!)
                return user
            } else {
                user = userLocalDataSource.getUserFromDB().let {
                    userMapper.get().toMapper(it)
                }
                return user
            }
        } else {
            user = userLocalDataSource.getUserFromDB().let {
                userMapper.get().toMapper(it)
            }
            return user
        }
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