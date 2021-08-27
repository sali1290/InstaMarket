package com.e.data.repository

import com.e.data.entity.TicketRequest
import com.e.data.entity.local.Ticket
import com.e.data.mapper.TicketMapper
import com.e.data.mapper.TicketRequestMapper
import com.e.data.repository.ticketDataSource.local.TicketLocalDataSource
import com.e.data.repository.ticketDataSource.remote.TicketRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.TicketModel
import com.e.domain.models.TicketRequestModel
import com.e.domain.repository.TicketRepo
import java.io.IOException
import java.lang.Exception

class TicketRepoImpl(
    private val ticketLocalDataSource: TicketLocalDataSource,
    private val ticketRemoteDataSource: TicketRemoteDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val ticketMapper: dagger.Lazy<TicketMapper>,
    private val ticketRequestMapper: dagger.Lazy<TicketRequestMapper>
) : TicketRepo {

    @Throws(IOException::class)
    override suspend fun createTicket(
        subject: String,
        orderId: String,
        type: String,
        description: String
    ): TicketRequestModel {
        lateinit var ticketRequest: TicketRequestModel
        if (netWorkHelper.isNetworkConnected()) {
            if (ticketRemoteDataSource.createTicketFromRemote(
                    subject,
                    orderId,
                    type,
                    description
                ).isSuccessful && ticketRemoteDataSource.createTicketFromRemote(
                    subject, orderId, type, description
                ).body() != null
            ) {
                val response = ticketRemoteDataSource.createTicketFromRemote(
                    subject, orderId, type, description
                ).body()
                ticketRequest = response.let {
                    ticketRequestMapper.get().toMapper(it!!)
                }
                ticketLocalDataSource.saveTicketFromDB(response?.ticket!!)
                return ticketRequest
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }


    @Throws(IOException::class)
    override suspend fun getTickets(id: String): MutableList<TicketModel> {
        lateinit var ticketList: MutableList<TicketModel>
        if (ticketLocalDataSource.getTicketListFromDB().size > 0) {
            for (i in 0..ticketLocalDataSource.getTicketListFromDB().size) {
                ticketList[i] = ticketLocalDataSource.getTicketListFromDB()[i].let {
                    ticketMapper.get().toMapper(it)
                }
            }
            return ticketList
        } else {
            if (netWorkHelper.isNetworkConnected()) {
                if (ticketRemoteDataSource.getTicketsFromRemote(id).isSuccessful &&
                    ticketRemoteDataSource.getTicketsFromRemote(id).body() != null
                ) {
                    val response = ticketRemoteDataSource.getTicketsFromRemote(id).body()
                    for (i in 0..response?.size!!) {
                        ticketList[i] = response[i].let {
                            ticketMapper.get().toMapper(it)
                        }
                        ticketLocalDataSource.saveTicketFromDB(response[i])
                    }
                    return ticketList
                } else {
                    throw IOException("Server is Not Responding")
                }
            } else {
                throw IOException("No Internet Connection")
            }
        }
    }
}