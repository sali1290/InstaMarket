package com.e.data.repository.ticketDataSource.local

import com.e.data.entity.TicketRequest

interface TicketLocalDataSource {

    suspend fun saveTicketFromDB(ticketRequest: TicketRequest)

    suspend fun deleteTicketFromDB()

    suspend fun getTicketListFromDB(): MutableList<TicketRequest>

}