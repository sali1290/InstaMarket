package com.e.domain.repository

import com.e.domain.models.*

interface AppInfoRepo {

    suspend fun getAgent(): MutableList<AgentsModel>

    suspend fun getApi(): MutableList<ApiModel>

    suspend fun getBanner(): MutableList<BannerModel>

    suspend fun getCategory(): MutableList<CategoryModel>

    suspend fun getFaq(): MutableList<FaqModel>

    suspend fun getNews(): MutableList<NewsModel>

    suspend fun getService(): MutableList<ServiceModel>

    suspend fun getSite(): MutableList<SiteModel>

}