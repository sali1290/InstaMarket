package com.e.data.mapper

import com.e.data.entity.local.LuckUser
import com.e.data.entity.remote.Service
import com.e.domain.models.LuckUserModel
import com.e.domain.models.ServiceModel
import java.util.*

class LuckUserMapper {
    fun toMapper(agents: LuckUser): LuckUserModel {
        return LuckUserModel(
            agents.id ?: 0,
            agents.coin ?: "",
            agents.date ?: Date(),
            agents.user_id ?: 0,
        )
    }
}