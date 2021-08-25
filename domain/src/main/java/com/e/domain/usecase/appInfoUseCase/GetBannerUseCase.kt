package com.e.domain.usecase.appInfoUseCase

import com.e.domain.repository.AppInfoRepo

class GetBannerUseCase (private val appInfoRepo: AppInfoRepo) {

    suspend fun execute() = appInfoRepo.getBanner()

}