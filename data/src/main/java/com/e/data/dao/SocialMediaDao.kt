package com.e.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SocialMediaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSocialMedia()

    @Query("SELECT * FROM SocialMedia")
    fun getSocialMedia()
}