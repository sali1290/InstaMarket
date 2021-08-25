package com.e.domain.usecase.luckUseCase

import com.e.domain.repository.LuckWheelRepo

class HaveChanceUseCase (private val luckWheelRepo: LuckWheelRepo){

    suspend fun execute() = luckWheelRepo.checkUserLuck()

}