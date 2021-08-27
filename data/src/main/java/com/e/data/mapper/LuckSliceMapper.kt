package com.e.data.mapper

import com.e.data.entity.remote.LuckSlice
import com.e.data.entity.remote.Service
import com.e.domain.models.LuckSliceModel
import com.e.domain.models.ServiceModel

class LuckSliceMapper {
    fun toMapper(agents: LuckSlice): LuckSliceModel {
        return LuckSliceModel(
            agents.id ?: 0,
            agents.name ?: "",
            agents.color ?: "",
            agents.value ?: ""
            )
    }
}