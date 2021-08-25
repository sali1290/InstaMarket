package com.e.domain.usecase.enterAppUseCase

import com.e.domain.repository.EnterAppRepo

class RegisterUseCase(private val enterAppRepo: EnterAppRepo) {

    suspend fun execute(
        email: String,
        phone: String,
        type: String,
        description: String,
        username: String,
        password: String
    ) = enterAppRepo.register(
        email, phone, type,
        description, username, password
    )

}