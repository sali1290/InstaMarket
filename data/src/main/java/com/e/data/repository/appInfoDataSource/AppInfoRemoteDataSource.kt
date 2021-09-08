package com.e.data.repository.appInfoDataSource

import com.e.data.entity.CategoryList
import com.e.data.entity.NewsList
import com.e.data.entity.ServiceList
import com.e.data.entity.remote.Banner
import com.e.data.entity.remote.*
import retrofit2.Response

interface AppInfoRemoteDataSource {

    suspend fun getAgentsFromRemote(): Response<MutableList<Agents>>

    suspend fun getApiFromRemote(): Response<MutableList<Api>>

    suspend fun getBannerFromRemote(): Response<MutableList<Banner>>

    suspend fun getFaqFromRemote(): Response<MutableList<Faq>>

    suspend fun getSiteFromRemote(): Response<MutableList<Site>>

    suspend fun getCategoryFromRemote(accessToken: String): Response<CategoryList>

    suspend fun getServiceFromRemote(accessToken: String): Response<ServiceList>

    suspend fun getNewsFromRemote(accessToken: String): Response<NewsList>


}