package com.e.data.mapper

import com.e.data.entity.LuckRequest
import com.e.data.entity.remote.Service
import com.e.domain.models.LuckRequestModel
import com.e.domain.models.ServiceModel
import javax.inject.Inject

class LuckRequestMapper @Inject constructor() {
    fun toMapper(agents: LuckRequest): LuckRequestModel {
        return LuckRequestModel(
            agents.result ?: true,
            LuckUserMapper().toMapper(agents.luck!!),
            agents.message ?: ""
        )
    }
}