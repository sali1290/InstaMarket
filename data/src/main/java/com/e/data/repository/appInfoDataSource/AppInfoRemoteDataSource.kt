package com.e.data.repository.appInfoDataSource

import com.e.data.entity.*
import retrofit2.Response

interface AppInfoRemoteDataSource {

    suspend fun getAgentsFromRemote(): Response<AgentList>

    suspend fun getApiFromRemote(): Response<ApiList>

    suspend fun getBannerFromRemote(): Response<BannerList>

    suspend fun getFaqFromRemote(): Response<FaqList>

    suspend fun getSiteFromRemote(): Response<SiteList>

    suspend fun getCategoryFromRemote(): Response<CategoryList>

    suspend fun getServiceFromRemote(): Response<ServiceList>

    suspend fun getNewsFromRemote(): Response<NewsList>

    suspend fun getAboutUsFromRemote(): Response<AboutUsResult>

    suspend fun getRulesFromRemote(): Response<AboutUsResult>

    suspend fun getContactUsFromRemote(): Response<AboutUsResult>

}