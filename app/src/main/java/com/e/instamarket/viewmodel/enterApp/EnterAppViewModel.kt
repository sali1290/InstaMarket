package com.e.instamarket.viewmodel.enterApp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.domain.Result
import com.e.domain.models.TokenModel
import com.e.domain.usecase.enterAppUseCase.LoginUseCase
import com.e.domain.usecase.enterAppUseCase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EnterAppViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase,
) : ViewModel() {

    private val _token = MutableLiveData<Result<TokenModel>>()
    val token: LiveData<Result<TokenModel>>
        get() = _token

    private val handler = CoroutineExceptionHandler { _, exception ->
        _token.postValue(exception.message?.let { Result.Error(it) })
    }


    fun login(email: String, password: String) = viewModelScope.launch(Dispatchers.IO + handler) {
        _token.postValue(Result.Loading)
        loginUseCase.execute(email, password).let {
            _token.postValue(Result.Success(it))
        }

    }

    fun register(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        userName: String,
        password: String,
        confirmPassword: String
    ) = viewModelScope.launch(Dispatchers.IO + handler) {
        _token.postValue(Result.Loading)
        registerUseCase.execute(
            email, phone, firstName,
            lastName, userName, password, confirmPassword
        ).let {
            _token.postValue(Result.Success(it))
        }


    }


}