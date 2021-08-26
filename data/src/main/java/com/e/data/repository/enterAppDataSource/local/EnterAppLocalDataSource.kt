package com.e.data.repository.enterAppDataSource.local

import com.e.data.entity.Token

interface EnterAppLocalDataSource {

    suspend fun saveTokenFromDB(token: Token)

    suspend fun getTokenFromDB(): Token

    suspend fun deleteTokenFromDB()


}