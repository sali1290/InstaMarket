package com.e.data.repository.luckWheelDataSource.remote

import com.e.data.entity.LuckRequest
import com.e.data.entity.LuckSliceList
import com.e.data.entity.remote.LuckSlice
import retrofit2.Response

interface LuckWheelRemoteDataSource {

    suspend fun getSlicesFromRemote(accessToken: String): Response<LuckSliceList>

    suspend fun getUserLuckFromRemote(accessToken: String): Response<Boolean>

    suspend fun createLuckFromRemote(accessToken: String, coin: String): Response<LuckRequest>
}