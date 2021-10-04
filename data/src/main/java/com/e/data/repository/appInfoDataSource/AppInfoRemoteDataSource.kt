package com.e.data.repository.appInfoDataSource

import com.e.data.entity.*
import com.e.data.entity.remote.*
import retrofit2.Response

interface AppInfoRemoteDataSource {

    suspend fun getAgentsFromRemote(): Response<AgentList>

    suspend fun getApiFromRemote(): Response<ApiList>

    suspend fun getBannerFromRemote(): Response<BannerList>

    suspend fun getFaqFromRemote(): Response<MutableList<Faq>>

    suspend fun getSiteFromRemote(): Response<SiteList>

    suspend fun getCategoryFromRemote(): Response<CategoryList>

    suspend fun getServiceFromRemote(): Response<ServiceList>

    suspend fun getNewsFromRemote(): Response<NewsList>


}