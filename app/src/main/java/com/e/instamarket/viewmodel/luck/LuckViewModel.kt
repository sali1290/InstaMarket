package com.e.instamarket.viewmodel.luck

import androidx.lifecycle.*
import com.e.domain.usecase.luckUseCase.HaveChanceUseCase
import com.e.domain.usecase.luckUseCase.LuckWheelUseCase
import com.e.domain.usecase.luckUseCase.UserLuckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import com.e.domain.Result
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

    fun setLuckWheel() = viewModelScope.launch(Dispatchers.IO+handler) {
        _luckSliceList.postValue(Result.Loading)
        luckWheelUseCase.execute().let{
            _luckSliceList.postValue(Result.Success(it))
        }
    }


    fun haveLuck() = liveData {
        val haveLuck = haveChanceUseCase.execute()
        emit(haveLuck)
    }

    fun userLuck(coin: String) = liveData {
        val userLuck = userLuckUseCase.execute(coin)
        emit(userLuck)
    }


}