package com.e.domain.usecase.userUseCase

import com.e.domain.repository.UserRepo
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(private val userRepo: UserRepo) {

    suspend fun execute(
        firstName: String?,
        lastName: String?,
        email: String?,
        username: String?,
        phone: String?,
//        birthday: String?,
//        education: String?,
//        marry: String?,
//        sex: String?
    ) = userRepo.updateUserInfo(
        firstName,
        lastName,
        email,
        username,
        phone,
//        birthday,
//        education,
//        marry,
//        sex
    )

}