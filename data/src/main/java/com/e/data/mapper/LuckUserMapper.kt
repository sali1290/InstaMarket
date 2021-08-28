package com.e.data.mapper

import com.e.data.entity.local.LuckUser
import com.e.data.entity.remote.Service
import com.e.domain.models.LuckUserModel
import com.e.domain.models.ServiceModel
import java.util.*
import javax.inject.Inject

class LuckUserMapper @Inject constructor(){
    fun toMapper(agents: LuckUser): LuckUserModel {
        return LuckUserModel(
            agents.id ?: 0,
            agents.coin ?: "",
            agents.date ?: Date(),
            agents.user_id ?: 0,
        )
    }
}