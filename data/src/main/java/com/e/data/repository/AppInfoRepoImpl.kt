package com.e.data.repository


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
                val response = appInfoRemoteDataSource.getAgentsFromRemote().body()
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

            if (appInfoRemoteDataSource.getApiFromRemote().isSuccessful && appInfoRemoteDataSource.getApiFromRemote()
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getApiFromRemote().body()
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
            if (appInfoRemoteDataSource.getBannerFromRemote().isSuccessful && appInfoRemoteDataSource.getBannerFromRemote(

                )
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getBannerFromRemote().body()
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
        if (netWorkHelper.isNetworkConnected()) {
            lateinit var categoryList: MutableList<CategoryModel>
            if (appInfoRemoteDataSource.getCategoryFromRemote().isSuccessful && appInfoRemoteDataSource.getCategoryFromRemote(

                )
                    .body() != null
            ) {
                val response = appInfoRemoteDataSource.getCategoryFromRemote()
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
        if (netWorkHelper.isNetworkConnected()) {
            if (appInfoRemoteDataSource.getNewsFromRemote().isSuccessful &&
                appInfoRemoteDataSource.getNewsFromRemote().body() != null
            ) {
                val response = appInfoRemoteDataSource.getNewsFromRemote()
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
            if (appInfoRemoteDataSource.getServiceFromRemote().isSuccessful &&
                appInfoRemoteDataSource.getServiceFromRemote().body() != null
            ) {
                val response = appInfoRemoteDataSource.getServiceFromRemote()
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