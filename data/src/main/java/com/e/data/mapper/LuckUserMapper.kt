package com.e.data.mapper

import com.e.data.entity.LuckUser
import com.e.domain.models.LuckUserModel
import javax.inject.Inject

class LuckUserMapper @Inject constructor(){
    fun toMapper(agents: LuckUser): LuckUserModel {
        return LuckUserModel(
            agents.date ?: "",
            agents.coin ?: "",
            agents.id ?: 0,
            agents.uid ?: 0,
        )
    }
}