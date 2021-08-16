package com.e.domain.usecase.userUseCase

import com.e.domain.repositories.UserRepo

class UpdateUserUseCase(private val userRepo: UserRepo) {

    suspend fun execute() = userRepo.updateUser()

}