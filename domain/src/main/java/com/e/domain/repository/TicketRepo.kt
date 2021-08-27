package com.e.domain.repository

import com.e.domain.models.TicketModel
import com.e.domain.models.TicketRequestModel

interface TicketRepo {

    suspend fun createTicket(
        subject: String,
        orderId: String,
        type: String,
        description: String
    ): TicketRequestModel

    suspend fun getTickets(id:String): MutableList<TicketModel>

}