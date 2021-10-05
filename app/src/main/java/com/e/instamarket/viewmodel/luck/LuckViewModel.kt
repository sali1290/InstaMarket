package com.e.instamarket.viewmodel.luck

import androidx.lifecycle.*
import com.e.domain.usecase.luckUseCase.HaveChanceUseCase
import com.e.domain.usecase.luckUseCase.LuckWheelUseCase
import com.e.domain.usecase.luckUseCase.UserLuckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import com.e.domain.Result
import com.e.domain.models.LuckRequestModel
import com.e.domain.models.LuckSliceModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LuckViewModel @Inject constructor(
    private val haveChanceUseCase: HaveChanceUseCase,
    private val luckWheelUseCase: LuckWheelUseCase,
    private val userLuckUseCase: UserLuckUseCase
) : ViewModel() {

    private val _luckSliceList = MutableLiveData<Result<MutableList<LuckSliceModel>>>()
    val luckSliceList: LiveData<Result<MutableList<LuckSliceModel>>>
        get() = _luckSliceList

    private val handler = CoroutineExceptionHandler { _, exception ->
        _luckSliceList.postValue(exception.message?.let { Result.Error(it) })
    }

    fun setLuckWheel() = viewModelScope.launch(Dispatchers.IO + handler) {
        _luckSliceList.postValue(Result.Loading)
        luckWheelUseCase.execute().let {
            _luckSliceList.postValue(Result.Success(it))
        }
    }


    private val _luck = MutableLiveData<Result<Boolean>>()
    val luck: LiveData<Result<Boolean>>
        get() = _luck

    private val luckHandler = CoroutineExceptionHandler { _, exception ->
        _luck.postValue(exception.message?.let { Result.Error(it) })
    }

    fun haveLuck() = viewModelScope.launch(Dispatchers.IO + luckHandler) {
        _luck.postValue(Result.Loading)
        haveChanceUseCase.execute().let {
            _luck.postValue(Result.Success(it))
        }

    }

    private val _luckResponse = MutableLiveData<Result<LuckRequestModel>>()
    val luckResponse: LiveData<Result<LuckRequestModel>>
        get() = _luckResponse

    private val luckResponseHandler = CoroutineExceptionHandler { _, exception ->
        _luckResponse.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getLuckResponse(coin: String) =
        viewModelScope.launch(Dispatchers.IO + luckResponseHandler) {
            _luckResponse.postValue(Result.Loading)
            userLuckUseCase.execute(coin).let {
                _luckResponse.postValue(Result.Success(it))
            }

        }


}