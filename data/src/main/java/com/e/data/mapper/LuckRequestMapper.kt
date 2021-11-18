package com.e.data.mapper

import com.e.data.entity.LuckRequest
import com.e.domain.models.LuckRequestModel
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