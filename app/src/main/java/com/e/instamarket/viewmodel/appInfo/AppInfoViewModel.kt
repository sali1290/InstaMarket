package com.e.instamarket.viewmodel.appInfo

import androidx.lifecycle.*
import com.e.domain.Result
import com.e.domain.models.CategoryModel
import com.e.domain.models.NewsModel
import com.e.domain.models.ServiceModel
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
) : ViewModel() {

    private val _news = MutableLiveData<Result<MutableList<NewsModel>>>()
    val news: LiveData<Result<MutableList<NewsModel>>>
        get() = _news
    private val handler = CoroutineExceptionHandler { _, exception ->
        _news.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getNews() = viewModelScope.launch(Dispatchers.IO + handler) {
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


    fun getSite() = liveData {
        val siteList = getSiteUseCase.execute()
        emit(siteList)
    }

    fun getFaq() = liveData {
        val faqList = getFaqUseCase.execute()
        emit(faqList)
    }

    private val _category = MutableLiveData<Result<MutableList<CategoryModel>>>()
    val category: LiveData<Result<MutableList<CategoryModel>>>
        get() = _category
    private val categoryHandler = CoroutineExceptionHandler { _, exception ->
        _category.postValue(exception.message?.let { Result.Error(it) })
    }
    fun getCategory() = viewModelScope.launch(Dispatchers.IO + categoryHandler) {
        _category.postValue(Result.Loading)
        getCategoryUseCase.execute().let {
            _category.postValue(Result.Success(it))
        }
    }

    private val _service = MutableLiveData<Result<MutableList<ServiceModel>>>()
    val service: LiveData<Result<MutableList<ServiceModel>>>
        get() = _service
    private val serviceHandler = CoroutineExceptionHandler { _, exception ->
        _service.postValue(exception.message?.let { Result.Error(it) })
    }
    fun getService() = viewModelScope.launch(Dispatchers.IO + serviceHandler) {
        _service.postValue(Result.Loading)
        getServiceUseCase.execute().let {
            _service.postValue(Result.Success(it))
        }
    }

}
