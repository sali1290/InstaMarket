package com.e.instamarket.viewmodel.appInfo

import androidx.lifecycle.*
import com.e.domain.Result
import com.e.domain.models.*
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

    private val _apiList = MutableLiveData<Result<MutableList<ApiModel>>>()
    val apiList: LiveData<Result<MutableList<ApiModel>>>
        get() = _apiList
    private val apiHandler = CoroutineExceptionHandler { coroutineContext, exception ->
        _apiList.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getApi() = viewModelScope.launch(Dispatchers.IO + apiHandler) {
        _apiList.postValue(Result.Loading)
        getApiUseCase.execute().let {
            _apiList.postValue(Result.Success(it))
        }
    }


    private val _agentList = MutableLiveData<Result<MutableList<AgentsModel>>>()
    val agentList: LiveData<Result<MutableList<AgentsModel>>>
        get() = _agentList
    private val agentHandler = CoroutineExceptionHandler { coroutineContext, exception ->
        _agentList.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getAgent() = viewModelScope.launch(Dispatchers.IO + agentHandler) {
        _agentList.postValue(Result.Loading)
        getAgentUseCase.execute().let {
            _agentList.postValue(Result.Success(it))
        }

    }

    private val _banner = MutableLiveData<Result<MutableList<BannerModel>>>()
    val banner: LiveData<Result<MutableList<BannerModel>>>
        get() = _banner

    private val bannerHandler = CoroutineExceptionHandler { coroutineContext, exception ->
        _banner.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getBanners() = viewModelScope.launch(Dispatchers.IO + bannerHandler) {
        _banner.postValue(Result.Loading)
        getBannerUseCase.execute().let {
            _banner.postValue(Result.Success(it))
        }


    }

    private val _siteList = MutableLiveData<Result<MutableList<SiteModel>>>()
    val siteList: LiveData<Result<MutableList<SiteModel>>>
        get() = _siteList

    private val siteHandler = CoroutineExceptionHandler { _, exception ->
        _siteList.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getSites() = viewModelScope.launch(Dispatchers.IO + siteHandler) {
        _siteList.postValue(Result.Loading)
        getSiteUseCase.execute().let {
            _siteList.postValue(Result.Success(it))
        }

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
