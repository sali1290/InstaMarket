package com.e.domain.usecase.userUseCase

import com.e.domain.repository.UserRepo
import javax.inject.Inject

class UpdateUserBankInfoUseCase @Inject constructor(private val userRepo: UserRepo) {
    suspend fun execute(shcard: String, shshaba: String, bankName: String) =
        userRepo.updateUserBankInfo(shcard, shshaba, bankName)
}