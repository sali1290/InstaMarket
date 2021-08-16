package com.e.data.dao

import androidx.room.*
import com.e.data.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser()

    @Query("SELECT * FROM User")
    fun getUser(): User




}