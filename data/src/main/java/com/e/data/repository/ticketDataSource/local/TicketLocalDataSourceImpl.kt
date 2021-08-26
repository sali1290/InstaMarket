package com.e.data.repository.ticketDataSource.local

import com.e.data.dao.TicketRequestDao
import com.e.data.entity.TicketRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TicketLocalDataSourceImpl(private val ticketRequestDao: TicketRequestDao) :
    TicketLocalDataSource {
    override suspend fun saveTicketFromDB(ticketRequest: TicketRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            ticketRequestDao.saveTickets(ticketRequest)
        }
    }

    override suspend fun deleteTicketFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            ticketRequestDao.deleteTickets()
        }
    }

    override suspend fun getTicketListFromDB(): MutableList<TicketRequest> {
        return ticketRequestDao.getTicketsList()
    }
}