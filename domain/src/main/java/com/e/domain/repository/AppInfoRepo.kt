package com.e.domain.repository

import com.e.data.entity.remote.Banner
import com.e.data.entity.remote.*

interface AppInfoRepo {

    suspend fun getAgent(): MutableList<Agents>

    suspend fun getApi(): MutableList<Api>

    suspend fun getBanner(): MutableList<Banner>

    suspend fun getCategory(): MutableList<Category>

    suspend fun getFaq(): MutableList<Faq>

    suspend fun getNews(): MutableList<News>

    suspend fun getService(): MutableList<Service>

    suspend fun getSite(): MutableList<Site>

}