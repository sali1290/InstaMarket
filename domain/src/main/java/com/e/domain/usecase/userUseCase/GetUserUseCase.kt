package com.e.domain.usecase.userUseCase

import com.e.domain.repository.UserRepo
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepo: UserRepo) {

    suspend fun execute() = userRepo.getUser()

}