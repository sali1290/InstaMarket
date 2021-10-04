package com.e.data.repository


import com.e.data.mapper.*
import com.e.data.repository.appInfoDataSource.AppInfoRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.*
import com.e.domain.repository.AppInfoRepo
import java.io.IOException
import javax.inject.Inject


class AppInfoRepoImpl @Inject constructor(
    private val agentMapper: dagger.Lazy<AgentMapper>,
    private val apiMapper: dagger.Lazy<ApiMapper>,
    private val bannerMapper: dagger.Lazy<BannerMapper>,
    private val categoryMapper: dagger.Lazy<CategoryMapper>,
    private val faqMapper: dagger.Lazy<FaqMapper>,
    private val newsMapper: dagger.Lazy<NewsMapper>,
    private val serviceMapper: dagger.Lazy<ServiceMapper>,
    private val siteMapper: dagger.Lazy<SiteMapper>,
    private val appInfoRemoteDataSource: AppInfoRemoteDataSource,
    private val netWorkHelper: NetWorkHelper,
) : AppInfoRepo {

    @Throws(IOException::class)
    override suspend fun getAgent(): MutableList<AgentsModel> {

        if (netWorkHelper.isNetworkConnected()) {
            lateinit var agentList: MutableList<AgentsModel>
            val request = appInfoRemoteDataSource.getAgentsFromRemote()
            if (request.isSuccessful &&
                request.body() != null
            ) {
                val response = request.body()
                agentList = response!!.agentList.map {
                    agentMapper.get().toMapper(it)
                }.toMutableList()
            } else {
                throw IOException("Server is Not Responding")
            }
            return agentList
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun getApi(): MutableList<ApiModel> {
        if (netWorkHelper.isNetworkConnected()) {
            lateinit var apiList: MutableList<ApiModel>
            val request = appInfoRemoteDataSource.getApiFromRemote()
            if (request.isSuccessful && request.body() != null) {
                val response = request.body()
                apiList = response!!.apiList.map {
                    apiMapper.get().toMapper(it)
                }.toMutableList()
                return apiList
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun getBanner(): MutableList<BannerModel> {
        lateinit var bannerList: MutableList<BannerModel>
        val request = appInfoRemoteDataSource.getBannerFromRemote()
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful && request.body() != null) {
                val response = request.body()
                bannerList = response!!.bannerList.map {
                    bannerMapper.get().toMapper(it)
                }.toMutableList()
                return bannerList
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun getCategory(): MutableList<CategoryModel> {
        lateinit var categoryList: MutableList<CategoryModel>
        val request = appInfoRemoteDataSource.getCategoryFromRemote()
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful && request.body() != null) {
                val response = request.body()
                categoryList = response!!.categoryList.map {
                    categoryMapper.get().toMapper(it)
                }.toMutableList()

                return categoryList
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun getFaq(): MutableList<FaqModel> {
        lateinit var faqList: MutableList<FaqModel>
        val request = appInfoRemoteDataSource.getFaqFromRemote()
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful && request.body() != null) {
                for (i in 0..request.body()?.size!!) {
                    faqList[i] = request.body()!![i].let {
                        faqMapper.get().toMapper(it)
                    }
                }
                return faqList
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun getNews(): MutableList<NewsModel> {
        lateinit var newsList: MutableList<NewsModel>
        val request = appInfoRemoteDataSource.getNewsFromRemote()
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful &&
                request.body() != null
            ) {
                newsList = request.body()!!.newsList.map {
                    newsMapper.get().toMapper(it)
                }.toMutableList()

                return newsList
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun getService(): MutableList<ServiceModel> {
        lateinit var serviceList: MutableList<ServiceModel>
        val request = appInfoRemoteDataSource.getServiceFromRemote()
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful &&
                request.body() != null
            ) {
                serviceList = request.body()!!.serviceList.map {
                    serviceMapper.get().toMapper(it)
                }.toMutableList()
                return serviceList
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun getSite(): MutableList<SiteModel> {
        lateinit var siteList: MutableList<SiteModel>
        val request = appInfoRemoteDataSource.getSiteFromRemote()
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful && request
                    .body() != null
            ) {
                siteList = request.body()!!.siteList.map {
                    siteMapper.get().toMapper(it)
                }.toMutableList()
                return siteList
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }


}