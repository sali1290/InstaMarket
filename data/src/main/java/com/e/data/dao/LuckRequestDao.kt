package com.e.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.e.data.entity.LuckRequest

@Dao
interface LuckRequestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLuck(luckRequest: LuckRequest)

    @Query("DELETE FROM LuckRequest")
    suspend fun deleteLuckHistory()

    @Query("SELECT * FROM LuckRequest")
    suspend fun getLuckList(): MutableList<LuckRequest>
}