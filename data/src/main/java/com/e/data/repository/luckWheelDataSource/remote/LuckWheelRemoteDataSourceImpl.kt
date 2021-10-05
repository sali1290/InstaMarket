package com.e.data.repository.luckWheelDataSource.remote

import com.e.data.api.ApiService
import com.e.data.api.CoinRequest
import com.e.data.entity.LuckRequest
import com.e.data.entity.LuckSliceList
import retrofit2.Response
import javax.inject.Inject

class LuckWheelRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    LuckWheelRemoteDataSource {
    override suspend fun getSlicesFromRemote(): Response<LuckSliceList> {
        return apiService.getLuckSlice()
    }

    override suspend fun getUserLuckFromRemote(): Response<Boolean> {
        return apiService.checkUserLuck()
    }

    override suspend fun createLuckFromRemote(coinRequest: CoinRequest): Response<LuckRequest> {
        return apiService.createLuck(coinRequest)
    }
}