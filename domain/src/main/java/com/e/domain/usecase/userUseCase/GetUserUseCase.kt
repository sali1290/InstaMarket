package com.e.domain.usecase.userUseCase

import com.e.domain.repository.EnterAppRepo
import com.e.domain.repository.UserRepo
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val enterAppRepo: EnterAppRepo) {

    suspend fun execute() = enterAppRepo.getUserFromLogin()

}