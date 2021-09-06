package com.e.domain.usecase.enterAppUseCase

import com.e.domain.repository.EnterAppRepo
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val enterAppRepo: EnterAppRepo) {

    suspend fun execute(
        email: String,
        phone: String,
        firstName: String,
        lastName: String,
        userName: String,
        password: String,
        confirmPassword: String
    ) = enterAppRepo.register(
        email, phone, firstName, lastName,
        userName, password, confirmPassword
    )

}