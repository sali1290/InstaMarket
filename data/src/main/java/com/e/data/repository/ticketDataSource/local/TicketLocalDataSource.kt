package com.e.data.repository.ticketDataSource.local

import com.e.data.entity.local.Ticket

interface TicketLocalDataSource {

    suspend fun saveTicketFromDB(ticket: Ticket)

    suspend fun deleteTicketFromDB()

    suspend fun getTicketListFromDB(): MutableList<Ticket>

}