package com.e.data.repository.enterAppDataSource.local

import com.e.data.dao.TokenDao
import com.e.data.entity.Token
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EnterAppLocalDataSourceImpl(
    private val tokenDao: TokenDao
) : EnterAppLocalDataSource {

    override suspend fun saveTokenFromDB(token: Token) {
        CoroutineScope(Dispatchers.IO).launch {
            tokenDao.saveToken(token)
        }
    }

    override suspend fun getTokenFromDB(): Token {
        return tokenDao.getToken()
    }

    override suspend fun deleteTokenFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            tokenDao.deleteToken()
        }
    }
}