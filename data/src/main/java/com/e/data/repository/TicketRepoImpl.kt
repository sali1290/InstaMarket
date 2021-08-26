package com.e.data.repository

import com.e.data.entity.TicketRequest
import com.e.data.entity.local.Ticket
import com.e.data.repository.ticketDataSource.local.TicketLocalDataSource
import com.e.data.repository.ticketDataSource.remote.TicketRemoteDataSource
import com.e.domain.models.TicketModel
import com.e.domain.models.TicketRequestModel
import com.e.domain.repository.TicketRepo
import java.lang.Exception

class TicketRepoImpl(
    private val ticketLocalDataSource: TicketLocalDataSource,
    private val ticketRemoteDataSource: TicketRemoteDataSource
) : TicketRepo {
    override suspend fun createTicket(
        subject: String,
        orderId: String,
        type: String,
        description: String
    ): TicketRequest {
        var ticketRequest: TicketRequest? = null
        try {
            if (ticketRemoteDataSource.createTicketFromRemote(
                    subject,
                    orderId,
                    type,
                    description
                ).isSuccessful
            ) {
                ticketRequest = ticketRemoteDataSource.createTicketFromRemote(
                    subject,
                    orderId,
                    type,
                    description
                ).body()
                if (ticketRequest?.result == true) {
                    ticketLocalDataSource.saveTicketFromDB(ticketRequest.ticket!!)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ticketRequest!!
    }

    override suspend fun getTickets(id: String): MutableList<Ticket> {
        var ticketList: MutableList<Ticket>? = null
        try {
            if (ticketLocalDataSource.getTicketListFromDB().isNotEmpty()) {
                ticketList = ticketLocalDataSource.getTicketListFromDB()
            } else {
                ticketList = ticketRemoteDataSource.getTicketsFromRemote(id).body()
                for (i in 0..ticketList?.size!!) {
                    ticketLocalDataSource.saveTicketFromDB(ticketList[i]!!)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ticketList!!
    }
}