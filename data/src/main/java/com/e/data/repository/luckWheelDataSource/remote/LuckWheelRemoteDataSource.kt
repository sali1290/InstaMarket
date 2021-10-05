package com.e.data.repository.luckWheelDataSource.remote

import com.e.data.api.CoinRequest
import com.e.data.entity.LuckRequest
import com.e.data.entity.LuckSliceList
import retrofit2.Response

interface LuckWheelRemoteDataSource {

    suspend fun getSlicesFromRemote(): Response<LuckSliceList>

    suspend fun getUserLuckFromRemote(): Response<Boolean>

    suspend fun createLuckFromRemote(coinRequest: CoinRequest): Response<LuckRequest>
}