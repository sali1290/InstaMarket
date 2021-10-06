package com.e.domain.usecase.enterAppUseCase

import com.e.domain.repository.EnterAppRepo
import javax.inject.Inject

class GetUserFromLoginUseCase @Inject constructor(private val enterAppRepo: EnterAppRepo) {

    suspend fun execute() = enterAppRepo.getUserFromLogin()

}