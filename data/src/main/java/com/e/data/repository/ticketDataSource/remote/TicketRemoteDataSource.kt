package com.e.data.repository.ticketDataSource.remote

import com.e.data.entity.TicketRequest
import com.e.data.entity.Ticket
import retrofit2.Response


interface TicketRemoteDataSource {

    suspend fun createTicketFromRemote(
        subject: String,
        order_id: String,
        type: String,
        description: String
    ): Response<TicketRequest>

    suspend fun getTicketsFromRemote(id: String): Response<MutableList<Ticket>>

}