package com.e.instamarket.viewmodel.enterApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.e.domain.usecase.enterAppUseCase.GetUserTokenUseCase
import com.e.domain.usecase.enterAppUseCase.LoginUseCase
import com.e.domain.usecase.enterAppUseCase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EnterAppViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getUserTokenUseCase: GetUserTokenUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    fun login(email: String, password: String) = liveData {
        val token = loginUseCase.execute(email, password)
        emit(token)
    }

    fun checkUser() = liveData {
        val token = getUserTokenUseCase.execute()
        emit(token)
    }

    fun register(
        email: String, phone: String, type: String,
        description: String, username: String, password: String
    ) = liveData {
        val token = registerUseCase.execute(
            email, phone, type,
            description, username, password
        )
        emit(token)
    }


}