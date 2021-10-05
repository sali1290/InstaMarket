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
    private val getSiteUseCase: GetSiteUseCase,
    private val getAboutUsUseCase: GetAboutUsUseCase,
    private val getRulesUseCase: GetRulesUseCase,
    private val getContactUsUseCase: GetContactUsUseCase
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
    private val apiHandler = CoroutineExceptionHandler { _, exception ->
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
    private val agentHandler = CoroutineExceptionHandler { _, exception ->
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

    private val bannerHandler = CoroutineExceptionHandler { _, exception ->
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

    private val _faqList = MutableLiveData<Result<MutableList<FaqModel>>>()
    val faqList: LiveData<Result<MutableList<FaqModel>>>
        get() = _faqList

    private val faqHandler = CoroutineExceptionHandler { _, exception ->
        _faqList.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getFaq() = viewModelScope.launch(Dispatchers.IO + faqHandler) {
        _faqList.postValue(Result.Loading)
        getFaqUseCase.execute().let {
            _faqList.postValue(Result.Success(it))
        }
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


    private val _aboutUs = MutableLiveData<Result<AboutUsModel>>()
    val aboutUs: LiveData<Result<AboutUsModel>>
        get() = _aboutUs
    private val aboutUsHandler = CoroutineExceptionHandler { _, exception ->
        _aboutUs.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getAboutUs() = viewModelScope.launch(Dispatchers.IO + aboutUsHandler) {
        _aboutUs.postValue(Result.Loading)
        getAboutUsUseCase.execute().let {
            _aboutUs.postValue(Result.Success(it))
        }
    }

    private val _rules = MutableLiveData<Result<AboutUsModel>>()
    val rules: LiveData<Result<AboutUsModel>>
        get() = _rules
    private val rulesHandler = CoroutineExceptionHandler { _, exception ->
        _rules.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getRules() = viewModelScope.launch(Dispatchers.IO + rulesHandler) {
        _rules.postValue(Result.Loading)
        getRulesUseCase.execute().let {
            _rules.postValue(Result.Success(it))
        }
    }

    private val _contactUs = MutableLiveData<Result<AboutUsModel>>()
    val contactUs: LiveData<Result<AboutUsModel>>
        get() = _contactUs
    private val contactUsHandler = CoroutineExceptionHandler { _, exception ->
        _contactUs.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getContactUs() = viewModelScope.launch(Dispatchers.IO + contactUsHandler) {
        _contactUs.postValue(Result.Loading)
        getContactUsUseCase.execute().let {
            _contactUs.postValue(Result.Success(it))
        }
    }


}
