package com.e.domain.usecase.userUseCase

import com.e.domain.repository.UserRepo
import javax.inject.Inject

class GetBlogsUseCase @Inject constructor(private val userRepo: UserRepo) {

    suspend fun execute() = userRepo.getBlogs()

}