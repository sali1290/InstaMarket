package com.e.instamarket.viewmodel.appInfo

import androidx.lifecycle.*
import com.e.domain.Result
import com.e.domain.models.NewsModel
import com.e.domain.usecase.appInfoUseCase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
): ViewModel() {

    private val _news = MutableLiveData<Result<MutableList<NewsModel>>>()
    val news: LiveData<Result<MutableList<NewsModel>>>
        get() = _news
    private val handler = CoroutineExceptionHandler { _, exception ->
        _news.postValue(exception.message?.let { Result.Error(it) })
    }
    fun getNews() = viewModelScope.launch(Dispatchers.IO+handler) {
        _news.postValue(Result.Loading)
        getNewsUseCase.execute().let {
            _news.postValue(Result.Success(it))
        }
    }



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



    fun getService() = liveData {
        val serviceList = getServiceUseCase.execute()
        emit(serviceList)
    }
    fun getSite() = liveData {
        val siteList = getSiteUseCase.execute()
        emit(siteList)
    }


}