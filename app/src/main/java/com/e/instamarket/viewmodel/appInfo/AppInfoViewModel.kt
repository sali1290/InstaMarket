package com.e.instamarket.viewmodel.appInfo

import androidx.lifecycle.liveData
import com.e.domain.usecase.appInfoUseCase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppInfoViewModel @Inject constructor(
    private val getAgentUseCase: GetAgentUseCase,
    private val getApiUseCase: GetApiUseCase,
    private val getBannerUseCase: GetBannerUseCase,
    private val getCategoryUseCase: GetCategoryUseCase,
    private val getFaqUseCase: GetFaqUseCase,
    private val getNewsUseCase: GetNewsUseCase,
    private val getServiceUseCase: GetServiceUseCase,
    private val getSiteUseCase: GetSiteUseCase
) {

    fun getAgent() = liveData {
        val agentsList = getAgentUseCase.execute()
        emit(agentsList)
    }

    fun getApi() = liveData {
        val apiList = getApiUseCase.execute()
        emit(apiList)
    }

    fun getBanner() = liveData {
        val bannersList = getBannerUseCase.execute()
        emit(bannersList)
    }

    fun getCategory() = liveData {
        val categoryList = getCategoryUseCase.execute()
        emit(categoryList)
    }

    fun getFaq() = liveData {
        val faqList = getFaqUseCase.execute()
        emit(faqList)
    }

    fun getNews() = liveData {
        val newsList = getNewsUseCase.execute()
        emit(newsList)
    }

    fun getService() = liveData {
        val serviceList = getServiceUseCase.execute()
        emit(serviceList)
    }
    fun getSite() = liveData {
        val siteList = getSiteUseCase.execute()
        emit(siteList)
    }


}