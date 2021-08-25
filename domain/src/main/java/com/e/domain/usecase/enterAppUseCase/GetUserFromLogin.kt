package com.e.domain.usecase.enterAppUseCase

import com.e.domain.repository.EnterAppRepo

class GetUserFromLogin (private val enterAppRepo: EnterAppRepo) {

    suspend fun execute(
        email: String,
        phone: String,
        type: String,
        description: String,
        username: String,
        password: String
    ) = enterAppRepo.getUserFromLogin(
        email, phone, type,
        description, username, password
    )

}