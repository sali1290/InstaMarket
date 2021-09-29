package com.e.data.repository.appInfoDataSource

import com.e.data.api.ApiService
import com.e.data.entity.*
import com.e.data.entity.remote.Faq
import com.e.data.entity.remote.Site
import retrofit2.Response
import javax.inject.Inject

class AppInfoRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : AppInfoRemoteDataSource {

    override suspend fun getAgentsFromRemote(): Response<AgentList> {
        return apiService.getAgents()
    }

    override suspend fun getApiFromRemote(): Response<ApiList> {
        return apiService.getApi()
    }

    override suspend fun getBannerFromRemote(): Response<BannerList> {
        return apiService.getBanners()
    }

    override suspend fun getFaqFromRemote(): Response<MutableList<Faq>> {
        return apiService.getFaq()
    }

    override suspend fun getSiteFromRemote(): Response<MutableList<Site>> {
        return apiService.getSites()
    }

    override suspend fun getCategoryFromRemote(): Response<CategoryList> {
        return apiService.getCategory()
    }

    override suspend fun getServiceFromRemote(): Response<ServiceList> {
        return apiService.getService()
    }

    override suspend fun getNewsFromRemote(): Response<NewsList> {
        return apiService.getNews()
    }
}