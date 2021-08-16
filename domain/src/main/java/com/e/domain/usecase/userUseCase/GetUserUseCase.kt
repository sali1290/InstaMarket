package com.e.domain.usecase.userUseCase

import com.e.domain.repository.UserRepo

class GetUserUseCase(private val userRepo: UserRepo) {

    suspend fun execute() = userRepo.getUser()

}