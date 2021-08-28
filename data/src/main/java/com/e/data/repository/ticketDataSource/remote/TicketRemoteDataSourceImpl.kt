package com.e.data.repository.ticketDataSource.remote

import com.e.data.api.ApiService
import com.e.data.entity.TicketRequest
import com.e.data.entity.local.Ticket
import retrofit2.Response
import javax.inject.Inject

class TicketRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService): TicketRemoteDataSource {
    override suspend fun createTicketFromRemote(
        subject: String,
        order_id: String,
        type: String,
        description: String
    ): Response<TicketRequest> {
        return apiService.createTicket(subject , order_id , type , description)
    }

    override suspend fun getTicketsFromRemote(id: String): Response<MutableList<Ticket>> {
        return apiService.getTicket(id)
    }
}