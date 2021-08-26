package com.e.data.repository

import com.e.data.entity.Token
import com.e.data.repository.enterAppDataSource.local.EnterAppLocalDataSource
import com.e.data.repository.enterAppDataSource.remote.EnterAppRemoteDataSource
import com.e.domain.repository.EnterAppRepo
import java.lang.Exception

class EnterAppRepoImpl(
    private val enterAppRemoteDataSource: EnterAppRemoteDataSource,
    private val enterAppLocalDataSource: EnterAppLocalDataSource
) : EnterAppRepo {
    override suspend fun login(email: String, password: String): Token {
        var token: Token? = null
        try {
            if (enterAppRemoteDataSource.loginFromRemote(
                    email,
                    password
                ).isSuccessful
            ) {
                token = enterAppRemoteDataSource.loginFromRemote(email, password).body()
                if (token != null && token.result == true) {
                    enterAppLocalDataSource.saveTokenFromDB(token)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return token!!
    }

    override suspend fun register(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        username: String,
        password: String
    ): Token {
        var token: Token? = null
        try {
            if (enterAppRemoteDataSource.registerFromRemote(
                    email,
                    phone,
                    firstName,
                    lastName,
                    username,
                    password
                ).isSuccessful
            ) {
                token = enterAppRemoteDataSource.registerFromRemote(
                    email,
                    phone,
                    firstName,
                    lastName,
                    username,
                    password
                ).body()
                if (token != null && token.result == true) {
                    enterAppLocalDataSource.saveTokenFromDB(token)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return token!!
    }

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

    override suspend fun logout(
        email: String,
        phone: String,
        type: String,
        description: String,
        username: String,
        password: String
    ): String {

        var message: String? = ""
        try {
            if (enterAppRemoteDataSource.logout(
                    email,
                    phone,
                    type,
                    description,
                    username,
                    password
                ).isSuccessful
            ) {
                message =
                    enterAppRemoteDataSource.logout(
                        email,
                        phone,
                        type,
                        description,
                        username,
                        password
                    )
                        .body()
                if (message != "Unauthenticated") {
                    enterAppLocalDataSource.deleteTokenFromDB()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return message!!
    }
}