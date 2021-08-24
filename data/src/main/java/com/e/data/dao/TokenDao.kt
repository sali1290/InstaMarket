package com.e.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.e.data.entity.Token

@Dao
interface TokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveToken(token: Token)

    @Query("DELETE FROM Token")
    suspend fun deleteToken()

    @Query("SELECT * FROM Token")
    suspend fun getToken(): Token

}