package com.e.data.mapper

import com.e.data.entity.local.Ticket
import com.e.domain.models.TicketModel

class TicketMapper {
    fun toMapper(agents: Ticket): TicketModel {
        return TicketModel(
            agents.id ?: 0,
            agents.changed ?: "",
            agents.created ?: "",
            agents.description ?: "",
            agents.ids ?: "",
            agents.messages ?: listOf(),
            agents.status ?: "",
            agents.subject ?: "",
            agents.uid ?: ""
        )
    }
}