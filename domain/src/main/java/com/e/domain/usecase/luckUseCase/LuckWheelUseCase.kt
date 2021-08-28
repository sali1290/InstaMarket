package com.e.domain.usecase.luckUseCase

import com.e.domain.repository.LuckWheelRepo
import javax.inject.Inject

class LuckWheelUseCase @Inject constructor(private val luckWheelRepo: LuckWheelRepo){

    suspend fun execute() = luckWheelRepo.getSlices()

}