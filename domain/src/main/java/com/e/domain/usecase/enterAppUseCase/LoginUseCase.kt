package com.e.domain.usecase.enterAppUseCase

import com.e.domain.repository.EnterAppRepo

class LoginUseCase(private val enterAppRepo: EnterAppRepo) {

    suspend fun execute(
        email: String, password: String) = enterAppRepo.login(email, password)
}