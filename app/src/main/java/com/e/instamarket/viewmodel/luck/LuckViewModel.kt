package com.e.instamarket.viewmodel.luck

import androidx.lifecycle.liveData
import com.e.domain.usecase.luckUseCase.HaveChanceUseCase
import com.e.domain.usecase.luckUseCase.LuckWheelUseCase
import com.e.domain.usecase.luckUseCase.UserLuckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LuckViewModel @Inject constructor(
    private val haveChanceUseCase: HaveChanceUseCase,
    private val luckWheelUseCase: LuckWheelUseCase,
    private val userLuckUseCase: UserLuckUseCase
){
    fun haveLuck() = liveData {
        val haveLuck = haveChanceUseCase.execute()
        emit(haveLuck)
    }
    fun luckWheel() = liveData {
        val luckWheel = luckWheelUseCase.execute()
        emit(luckWheel)
    }
    fun userLuck(coin : String) = liveData {
        val userLuck = userLuckUseCase.execute(coin)
        emit(userLuck)
    }




}