package com.e.domain.usecase

import com.e.domain.models.UserModel
import com.e.domain.repositories.UserRepo

class UserUseCaseImpl(private val userRepo: UserRepo) : UserUseCase<UserModel> {

    override suspend fun execute(): MutableList<UserModel> {
        return userRepo.getUser()
    }

}