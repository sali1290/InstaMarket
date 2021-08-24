package com.e.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.e.data.entity.Banner

@Dao
interface BannerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBanner(banner: Banner)

    @Query("DELETE FROM Banner")
    suspend fun deleteBanners()

    @Query("SELECT * FROM BANNER")
    suspend fun getBannerList(): MutableList<Banner>

}