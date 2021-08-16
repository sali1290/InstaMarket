package com.e.domain.usecase.userUseCase

import com.e.domain.repositories.UserRepo

class GetUserUseCase(private val userRepo: UserRepo) {

    suspend fun execute() = userRepo.getUser()

}