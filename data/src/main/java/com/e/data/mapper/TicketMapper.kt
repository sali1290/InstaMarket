package com.e.data.mapper

import com.e.data.entity.Ticket
import com.e.domain.models.TicketModel
import javax.inject.Inject

class TicketMapper @Inject constructor(){
    fun toMapper(agents: Ticket): TicketModel {
        return TicketModel(
            agents.id ?: 0,
            agents.changed ?: "",
            agents.created ?: "",
            agents.description ?: "",
            agents.ids ?: "",
            ErrorsMapper().toMapper(agents.messages!!) ,
            agents.status ?: "",
            agents.subject ?: "",
            agents.uid ?: ""
        )
    }
}