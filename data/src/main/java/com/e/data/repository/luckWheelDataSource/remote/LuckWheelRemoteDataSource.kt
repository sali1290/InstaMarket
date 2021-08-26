package com.e.data.repository.luckWheelDataSource.remote

import com.e.data.entity.LuckRequest
import com.e.data.entity.remote.LuckSlice
import retrofit2.Response

interface LuckWheelRemoteDataSource {

    suspend fun getSlicesFromRemote(): Response<MutableList<LuckSlice>>

    suspend fun getUserLuckFromRemote(): Response<Boolean>

    suspend fun createLuckFromRemote(coin: String): Response<LuckRequest>
}