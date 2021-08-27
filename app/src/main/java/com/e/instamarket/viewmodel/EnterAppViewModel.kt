package com.e.instamarket.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.e.data.entity.Token
import com.e.domain.usecase.enterAppUseCase.GetUserFromLogin
import com.e.domain.usecase.enterAppUseCase.LoginUseCase

class EnterAppViewModel(
    private val loginUseCase: LoginUseCase,
    private val getUserFromLogin: GetUserFromLogin
) : ViewModel() {



}