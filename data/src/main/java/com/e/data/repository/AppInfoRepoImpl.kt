package com.e.data.repository


import android.util.Log
import android.widget.Toast
import com.e.data.mapper.*
import com.e.data.repository.appInfoDataSource.AppInfoRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.data.utile.SessionManager
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
    private val sessionManager: SessionManager
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
            val accessToken = sessionManager.fetchAuthToken()!!
            if (appInfoRemoteDataSource.getApiFromRemote(accessToken).isSuccessful && appInfoRemoteDataSource.getApiFromRemote(
                    accessToken
                )
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getApiFromRemote(accessToken).body()
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
            val accessToken: String = sessionManager.fetchAuthToken()!!
            if (appInfoRemoteDataSource.getCategoryFromRemote(accessToken).isSuccessful && appInfoRemoteDataSource.getCategoryFromRemote(
                    accessToken
                )
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getCategoryFromRemote(accessToken)
                categoryList = response.body()!!.categoryList.map {
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
        lateinit var newsList: MutableList<NewsModel>
        val accessToken: String = sessionManager.fetchAuthToken()!!
        if (netWorkHelper.isNetworkConnected()) {
            if (appInfoRemoteDataSource.getNewsFromRemote("Bearer $accessToken").isSuccessful &&
                appInfoRemoteDataSource.getNewsFromRemote("Bearer $accessToken").body() != null
            ) {
                val response = appInfoRemoteDataSource.getNewsFromRemote("Bearer $accessToken")
                newsList = response.body()!!.newsList.map {
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
        if (netWorkHelper.isNetworkConnected()) {
            lateinit var serviceList: MutableList<ServiceModel>
            val accessToken: String = sessionManager.fetchAuthToken()!!
            if (appInfoRemoteDataSource.getServiceFromRemote(accessToken).isSuccessful &&
                appInfoRemoteDataSource.getServiceFromRemote(accessToken).body() != null
            ) {
                val response = appInfoRemoteDataSource.getServiceFromRemote(accessToken)
                serviceList = response.body()!!.serviceList.map {
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