package com.e.instamarket.viewmodel.enterApp

import android.util.Log
import androidx.lifecycle.MutableLiveData
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


    fun login(email: String, password: String) = liveData  {
        val token = MutableLiveData(loginUseCase.execute(email , password))
        Log.i("My tag" , "value in viewModel is: " + token.value?.id.toString())
        emit(token)
    }

    fun checkUser() = liveData {
        val token = MutableLiveData(getUserTokenUseCase.execute())
        emit(token)
    }

    fun register(
        email: String, phone: String, type: String,
        description: String, username: String, password: String , confirmPassword:String
    ) = liveData {
         val token = MutableLiveData(registerUseCase.execute(
            email, phone, type,
            description, username, password , confirmPassword
        ))
        emit(token)
    }




}