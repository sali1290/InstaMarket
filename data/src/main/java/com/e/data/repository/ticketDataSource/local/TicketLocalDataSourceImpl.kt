package com.e.data.repository.ticketDataSource.local

import com.e.data.dao.TicketRequestDao
import com.e.data.entity.local.Ticket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TicketLocalDataSourceImpl(private val ticketRequestDao: TicketRequestDao) :
    TicketLocalDataSource {
    override suspend fun saveTicketFromDB(ticket: Ticket) {
        CoroutineScope(Dispatchers.IO).launch {
            ticketRequestDao.saveTickets(ticket)
        }
    }

    override suspend fun deleteTicketFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            ticketRequestDao.deleteTickets()
        }
    }

    override suspend fun getTicketListFromDB(): MutableList<Ticket> {
        return ticketRequestDao.getTicketsList()
    }
}