package com.e.domain.usecase.luckUseCase

import com.e.domain.repository.LuckWheelRepo

class UserLuckUseCase(private val luckWheelRepo: LuckWheelRepo) {

    suspend fun execute(coin: String) = luckWheelRepo.createUserLuck(coin)

}