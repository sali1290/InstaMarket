package com.e.domain.usecase.ticketUseCase

import com.e.domain.repository.TicketRepo

class GetTicketsUseCase(private val ticketRepo: TicketRepo) {

    suspend fun execute(id: String) = ticketRepo.getTickets(id)

}