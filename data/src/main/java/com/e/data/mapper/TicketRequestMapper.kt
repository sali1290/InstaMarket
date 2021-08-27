package com.e.data.mapper

import com.e.data.entity.TicketRequest
import com.e.data.entity.local.Ticket
import com.e.domain.models.TicketModel
import com.e.domain.models.TicketRequestModel

class TicketRequestMapper {
    fun toMapper(agents: TicketRequest): TicketRequestModel {
        return TicketRequestModel(
            agents.id ?: 0,
            agents.result ?: true,
            TicketMapper().toMapper(agents.ticket!!) ,
            agents.message ?: ""
        )
    }
}