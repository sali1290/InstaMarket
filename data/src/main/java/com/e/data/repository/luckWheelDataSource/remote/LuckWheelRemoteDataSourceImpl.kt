package com.e.data.repository.luckWheelDataSource.remote

import com.e.data.api.ApiService
import com.e.data.entity.LuckRequest
import com.e.data.entity.remote.LuckSlice
import retrofit2.Response
import javax.inject.Inject

class LuckWheelRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    LuckWheelRemoteDataSource {
    override suspend fun getSlicesFromRemote(): Response<MutableList<LuckSlice>> {
        return apiService.getLuckSlice()
    }

    override suspend fun getUserLuckFromRemote(): Response<Boolean> {
        return apiService.checkUserLuck()
    }

    override suspend fun createLuckFromRemote(coin: String): Response<LuckRequest> {
        return apiService.createLuck(coin)
    }
}