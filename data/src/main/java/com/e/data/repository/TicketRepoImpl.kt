package com.e.data.repository

import com.e.domain.models.TicketModel
import com.e.domain.models.TicketRequestModel
import com.e.domain.repository.TicketRepo

class TicketRepoImpl: TicketRepo {
    override suspend fun createTicket(
        subject: String,
        orderId: String,
        type: String,
        description: String
    ): TicketRequestModel {
        TODO("Not yet implemented")
    }

    override suspend fun getTickets(id: String): MutableList<TicketModel> {
        TODO("Not yet implemented")
    }
}