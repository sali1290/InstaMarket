package com.e.data.mapper

import com.e.data.entity.TicketRequest
import com.e.domain.models.TicketRequestModel
import javax.inject.Inject

class TicketRequestMapper @Inject constructor(){
    fun toMapper(agents: TicketRequest): TicketRequestModel {
        return TicketRequestModel(
            agents.id ?: 0,
            agents.result ?: true,
            TicketMapper().toMapper(agents.ticket!!) ,
            agents.message ?: ""
        )
    }
}