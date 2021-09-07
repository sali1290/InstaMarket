package com.e.instamarket.viewmodel.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.domain.Result
import com.e.domain.models.UserModel
import com.e.domain.usecase.userUseCase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCase: GetUserUseCase
) : ViewModel() {

    private val _user = MutableLiveData<Result<UserModel>>()
    val user: LiveData<Result<UserModel>>
        get() = _user

    private val handler = CoroutineExceptionHandler { _, exception ->
        _user.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getUser() = viewModelScope.launch(Dispatchers.IO + handler) {
        _user.postValue(Result.Loading)
        userUseCase.execute().let {
            _user.postValue(Result.Success(it!!))
        }
    }

}

