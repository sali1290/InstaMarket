package com.e.data.repository

import com.e.data.entity.remote.Banner
import com.e.data.entity.remote.*
import com.e.data.repository.appInfoDataSource.AppInfoRemoteDataSource
import com.e.domain.repository.AppInfoRepo
import java.lang.Exception

class AppInfoRepoImpl(
    private val appInfoRemoteDataSource: AppInfoRemoteDataSource
) : AppInfoRepo {

    override suspend fun getAgent(): MutableList<Agents> {
        var agentList: MutableList<Agents>? = null
        try {
            if (appInfoRemoteDataSource.getAgentsFromRemote().isSuccessful) {
                val response = appInfoRemoteDataSource.getAgentsFromRemote()
                agentList = response.body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return agentList!!
    }


    override suspend fun getApi(): MutableList<Api> {
        var apiList: MutableList<Api>? = null
        try {
            if (appInfoRemoteDataSource.getApiFromRemote().isSuccessful) {
                val response = appInfoRemoteDataSource.getApiFromRemote()
                apiList = response.body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return apiList!!
    }

    override suspend fun getBanner(): MutableList<Banner> {
        var bannerList: MutableList<Banner>? = null
        try {
            if (appInfoRemoteDataSource.getBannerFromRemote().isSuccessful) {
                val response = appInfoRemoteDataSource.getBannerFromRemote()
                bannerList = response.body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bannerList!!
    }

    override suspend fun getCategory(): MutableList<Category> {
        var categoryList: MutableList<Category>? = null
        try {
            if (appInfoRemoteDataSource.getCategoryFromRemote().isSuccessful) {
                val response = appInfoRemoteDataSource.getCategoryFromRemote()
                categoryList = response.body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return categoryList!!
    }

    override suspend fun getFaq(): MutableList<Faq> {
        var faqList: MutableList<Faq>? = null
        try {
            if (appInfoRemoteDataSource.getFaqFromRemote().isSuccessful) {
                val response = appInfoRemoteDataSource.getFaqFromRemote()
                faqList = response.body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return faqList!!
    }

    override suspend fun getNews(): MutableList<News> {
        var newsList: MutableList<News>? = null
        try {
            if (appInfoRemoteDataSource.getNewsFromRemote().isSuccessful) {
                val response = appInfoRemoteDataSource.getNewsFromRemote()
                newsList = response.body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return newsList!!
    }

    override suspend fun getService(): MutableList<Service> {
        var serviceList: MutableList<Service>? = null
        try {
            if (appInfoRemoteDataSource.getServiceFromRemote().isSuccessful) {
                val response = appInfoRemoteDataSource.getServiceFromRemote()
                serviceList = response.body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return serviceList!!
    }

    override suspend fun getSite(): MutableList<Site> {
        var siteList: MutableList<Site>? = null
        try {
            if (appInfoRemoteDataSource.getSiteFromRemote().isSuccessful) {
                val response = appInfoRemoteDataSource.getSiteFromRemote()
                siteList = response.body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return siteList!!
    }


}