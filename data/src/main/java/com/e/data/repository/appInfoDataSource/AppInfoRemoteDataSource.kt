package com.e.data.repository.appInfoDataSource

import com.e.data.entity.Banner
import com.e.data.entity.remote.*
import retrofit2.Response

interface AppInfoRemoteDataSource {

    suspend fun getAgentsFromRemote(): Response<MutableList<Agents>>

    suspend fun getApiFromRemote(): Response<MutableList<Api>>

    suspend fun getBannerFromRemote(): Response<MutableList<Banner>>

    suspend fun getFaqFromRemote(): Response<MutableList<Faq>>

    suspend fun getSiteFromRemote(): Response<MutableList<Site>>

    suspend fun getCategoryFromRemote(): Response<MutableList<Category>>

    suspend fun getServiceFromRemote(): Response<MutableList<Service>>

    suspend fun getNewsFromRemote(): Response<MutableList<News>>


}