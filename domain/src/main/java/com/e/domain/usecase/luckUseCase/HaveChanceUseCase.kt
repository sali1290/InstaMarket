package com.e.domain.usecase.luckUseCase

import com.e.domain.repository.LuckWheelRepo
import javax.inject.Inject

class HaveChanceUseCase @Inject constructor(private val luckWheelRepo: LuckWheelRepo){

    suspend fun execute() = luckWheelRepo.checkUserLuck()

}