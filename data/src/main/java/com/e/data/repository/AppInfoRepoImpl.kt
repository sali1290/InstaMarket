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
    private val netWorkHelper: NetWorkHelper
) : AppInfoRepo {

    @Throws(IOException::class)
    override suspend fun getAgent(): MutableList<AgentsModel> {
        if (netWorkHelper.isNetworkConnected()) {
            lateinit var agentList: MutableList<AgentsModel>
            if (appInfoRemoteDataSource.getAgentsFromRemote().isSuccessful &&
                appInfoRemoteDataSource.getAgentsFromRemote().body() != null
            ) {
                val response = appInfoRemoteDataSource.getAgentsFromRemote()
                for (i in 0..response.body()?.size!!) {
                    agentList[i] = response.body()!![i].let {
                        agentMapper.get().toMapper(it)
                    }
                }
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
            if (appInfoRemoteDataSource.getApiFromRemote().isSuccessful && appInfoRemoteDataSource.getApiFromRemote()
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getApiFromRemote()
                for (i in 0..response.body()?.size!!) {
                    apiList[i] = response.body()!![i].let {
                        apiMapper.get().toMapper(it)
                    }
                }
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
        if (netWorkHelper.isNetworkConnected()) {
            lateinit var bannerList: MutableList<BannerModel>
            if (appInfoRemoteDataSource.getBannerFromRemote().isSuccessful && appInfoRemoteDataSource.getBannerFromRemote()
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getBannerFromRemote()
                for (i in 0..response.body()?.size!!) {
                    bannerList[i] = response.body()!![i].let {
                        bannerMapper.get().toMapper(it)
                    }
                }
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
        if (netWorkHelper.isNetworkConnected()) {
            lateinit var categoryList: MutableList<CategoryModel>
            if (appInfoRemoteDataSource.getCategoryFromRemote().isSuccessful && appInfoRemoteDataSource.getCategoryFromRemote()
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getCategoryFromRemote()
                for (i in 0..response.body()?.size!!) {
                    categoryList[i] = response.body()!![i].let {
                        categoryMapper.get().toMapper(it)
                    }
                }
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
        if (netWorkHelper.isNetworkConnected()) {
            lateinit var faqList: MutableList<FaqModel>
            if (appInfoRemoteDataSource.getFaqFromRemote().isSuccessful && appInfoRemoteDataSource.getFaqFromRemote()
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getFaqFromRemote()
                for (i in 0..response.body()?.size!!) {
                    faqList[i] = response.body()!![i].let {
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
        if (netWorkHelper.isNetworkConnected()) {
            lateinit var newsList: MutableList<NewsModel>
            if (appInfoRemoteDataSource.getNewsFromRemote().isSuccessful && appInfoRemoteDataSource.getNewsFromRemote()
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getNewsFromRemote()
                for (i in 0..response.body()?.size!!) {
                    newsList[i] = response.body()!![i].let {
                        newsMapper.get().toMapper(it)
                    }
                }
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
        if (netWorkHelper.isNetworkConnected()) {
            lateinit var serviceList: MutableList<ServiceModel>
            if (appInfoRemoteDataSource.getServiceFromRemote().isSuccessful &&
                appInfoRemoteDataSource.getServiceFromRemote().body() != null
            ) {
                val response = appInfoRemoteDataSource.getServiceFromRemote()
                for (i in 0..response.body()?.size!!) {
                    serviceList[i] = response.body()!![i].let {
                        serviceMapper.get().toMapper(it)
                    }
                }
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
        if (netWorkHelper.isNetworkConnected()) {
            lateinit var siteList: MutableList<SiteModel>
            if (appInfoRemoteDataSource.getSiteFromRemote().isSuccessful && appInfoRemoteDataSource.getSiteFromRemote()
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getSiteFromRemote()
                for (i in 0..response.body()?.size!!) {
                    siteList[i] = response.body()!![i].let {
                        siteMapper.get().toMapper(it)
                    }
                }
                return siteList
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }


}