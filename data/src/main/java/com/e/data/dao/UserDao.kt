package com.e.data.dao

import androidx.room.*
import com.e.data.entity.local.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: User)

    @Query("SELECT * FROM USER")
    suspend fun getUser(): User

    @Query("DELETE FROM USER")
    suspend fun deleteUser()

}