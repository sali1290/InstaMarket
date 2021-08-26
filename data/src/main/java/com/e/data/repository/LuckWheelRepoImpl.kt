package com.e.data.repository

import com.e.data.entity.LuckRequest
import com.e.data.entity.remote.LuckSlice
import com.e.data.repository.luckWheelDataSource.local.LuckWheelLocalDataSource
import com.e.data.repository.luckWheelDataSource.remote.LuckWheelRemoteDataSource
import com.e.domain.models.LuckRequestModel
import com.e.domain.models.LuckSliceModel
import com.e.domain.repository.LuckWheelRepo
import java.lang.Exception

class LuckWheelRepoImpl(
    private val luckWheelRemoteDataSource: LuckWheelRemoteDataSource,
    private val luckWheelLocalDataSource: LuckWheelLocalDataSource
) : LuckWheelRepo {
    override suspend fun getSlices(): MutableList<LuckSlice> {
        var sliceList: MutableList<LuckSlice>? = null
        try {
            if (luckWheelRemoteDataSource.getSlicesFromRemote().isSuccessful) {
                sliceList = luckWheelRemoteDataSource.getSlicesFromRemote().body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return sliceList!!
    }

    override suspend fun checkUserLuck(): Boolean {
        var userLuck = true
        try {
            if (luckWheelRemoteDataSource.getUserLuckFromRemote().isSuccessful) {
                userLuck = luckWheelRemoteDataSource.getUserLuckFromRemote().body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return userLuck
    }

    override suspend fun createUserLuck(coin: String): LuckRequest {
        var luck: LuckRequest? = null
        try {
            if (luckWheelRemoteDataSource.createLuckFromRemote(coin).isSuccessful) {
                luck = luckWheelRemoteDataSource.createLuckFromRemote(coin).body()
                luckWheelLocalDataSource.saveLuckFromDB(luck!!)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return luck!!

    }
}