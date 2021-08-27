package com.e.data.mapper

import com.e.data.entity.remote.Agents
import com.e.domain.models.AgentsModel

class AgentMapper {
    fun toMapper(agents: Agents): AgentsModel {
        return AgentsModel(
            agents.id ?: 0,
            agents.day ?: "",
            agents.des ?: "",
            agents.flag ?: "",
            agents.name ?: "",
            agents.num ?: "",
            agents.price ?: "",
            agents.subject ?: ""
        )
    }
}