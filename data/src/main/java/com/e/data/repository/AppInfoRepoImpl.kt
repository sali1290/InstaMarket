package com.e.data.repository

import com.e.domain.models.*
import com.e.domain.repository.AppInfoRepo

class AppInfoRepoImpl : AppInfoRepo {
    override suspend fun getAgent(): MutableList<AgentsModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getApi(): MutableList<ApiModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getBanner(): MutableList<BannerModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategory(): MutableList<CategoryModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getFaq(): MutableList<FaqModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getNews(): MutableList<NewsModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getService(): MutableList<ServiceModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getSite(): MutableList<SiteModel> {
        TODO("Not yet implemented")
    }
}