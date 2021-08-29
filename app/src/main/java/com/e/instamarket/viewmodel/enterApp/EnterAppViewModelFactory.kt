package com.e.instamarket.viewmodel.enterApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e.domain.usecase.enterAppUseCase.GetUserTokenUseCase
import com.e.domain.usecase.enterAppUseCase.LoginUseCase
import com.e.domain.usecase.enterAppUseCase.RegisterUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EnterAppViewModelFactory @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getUserTokenUseCase: GetUserTokenUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EnterAppViewModel(loginUseCase, getUserTokenUseCase, registerUseCase) as T
    }
}