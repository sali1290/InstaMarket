package com.e.domain.usecase.appInfoUseCase

import com.e.domain.repository.AppInfoRepo


class GetAgentUseCase(private val appInfoRepo: AppInfoRepo) {

    suspend fun execute() = appInfoRepo.getAgent()

}