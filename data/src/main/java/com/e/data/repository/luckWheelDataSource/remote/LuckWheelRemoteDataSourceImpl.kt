package com.e.data.repository.luckWheelDataSource.remote

import com.e.data.api.ApiService
import com.e.data.entity.LuckRequest
import com.e.data.entity.LuckSliceList
import com.e.data.entity.remote.LuckSlice
import retrofit2.Response
import javax.inject.Inject

class LuckWheelRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    LuckWheelRemoteDataSource {
    override suspend fun getSlicesFromRemote(accessToken: String): Response<LuckSliceList> {
        return apiService.getLuckSlice(accessToken)
    }

    override suspend fun getUserLuckFromRemote(accessToken: String): Response<Boolean> {
        return apiService.checkUserLuck(accessToken)
    }

    override suspend fun createLuckFromRemote(accessToken: String ,coin: String): Response<LuckRequest> {
        return apiService.createLuck(accessToken , coin)
    }
}