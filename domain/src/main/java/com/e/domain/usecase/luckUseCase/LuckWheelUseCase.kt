package com.e.domain.usecase.luckUseCase

import com.e.domain.repository.LuckWheelRepo

class LuckWheelUseCase(private val luckWheelRepo: LuckWheelRepo){

    suspend fun execute() = luckWheelRepo.getSlices()

}