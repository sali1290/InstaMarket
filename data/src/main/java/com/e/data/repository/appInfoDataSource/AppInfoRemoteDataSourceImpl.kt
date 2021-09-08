package com.e.data.repository.appInfoDataSource

import com.e.data.api.ApiService
import com.e.data.entity.NewsList
import com.e.data.entity.remote.Banner
import com.e.data.entity.remote.*
import retrofit2.Response
import javax.inject.Inject

class AppInfoRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : AppInfoRemoteDataSource {

    override suspend fun getAgentsFromRemote(): Response<MutableList<Agents>> {
        return apiService.getAgents()
    }

    override suspend fun getApiFromRemote(): Response<MutableList<Api>> {
        return apiService.getApi()
    }

    override suspend fun getBannerFromRemote(): Response<MutableList<Banner>> {
        return apiService.getBanners()
    }

    override suspend fun getFaqFromRemote(): Response<MutableList<Faq>> {
        return apiService.getFaq()
    }

    override suspend fun getSiteFromRemote(): Response<MutableList<Site>> {
        return apiService.getSites()
    }

    override suspend fun getCategoryFromRemote(): Response<MutableList<Category>> {
        return apiService.getCategory()
    }

    override suspend fun getServiceFromRemote(): Response<MutableList<Service>> {
        return apiService.getService()
    }

    override suspend fun getNewsFromRemote(accessToken: String): Response<NewsList> {
        return apiService.getNews(accessToken)
    }
}