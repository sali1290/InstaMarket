package com.e.domain.repository

import com.e.data.entity.TicketRequest
import com.e.data.entity.local.Ticket

interface TicketRepo {

    suspend fun createTicket(
        subject: String,
        orderId: String,
        type: String,
        description: String
    ): TicketRequest

    suspend fun getTickets(id:String): MutableList<Ticket>

}