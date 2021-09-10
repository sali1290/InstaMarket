package com.e.data.repository.appInfoDataSource

import com.e.data.api.ApiService
import com.e.data.entity.ApiList
import com.e.data.entity.CategoryList
import com.e.data.entity.NewsList
import com.e.data.entity.ServiceList
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

    override suspend fun getApiFromRemote(accessToken: String): Response<ApiList> {
        return apiService.getApi(accessToken)
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

    override suspend fun getCategoryFromRemote(accessToken: String): Response<CategoryList> {
        return apiService.getCategory(accessToken)
    }

    override suspend fun getServiceFromRemote(accessToken: String): Response<ServiceList> {
        return apiService.getService(accessToken)
    }

    override suspend fun getNewsFromRemote(accessToken: String): Response<NewsList> {
        return apiService.getNews(accessToken)
    }
}