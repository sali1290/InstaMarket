package com.e.domain.usecase.userUseCase

import com.e.domain.repository.UserRepo

class UpdateUserUseCase(private val userRepo: UserRepo) {

    suspend fun execute() = userRepo.updateUser()

}