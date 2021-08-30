package com.e.instamarket.viewmodel.ticket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.e.domain.usecase.ticketUseCase.CreateTicketUseCase
import com.e.domain.usecase.ticketUseCase.GetTicketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class TicketViewModel @Inject constructor(
    private val createTicketUseCase: CreateTicketUseCase,
    private val getTicketsUseCase: GetTicketsUseCase
) : ViewModel() {

    fun createTicket(
        subject: String,
        orderId: String,
        type: String,
        description: String
    ) = liveData {
        val ticket = createTicketUseCase.execute(
            subject,
            orderId,
            type,
            description
        )
        emit(ticket)
    }

    fun getTickets(id: String) = liveData {
        val ticketList = getTicketsUseCase.execute(id)
        emit(ticketList)
    }

}