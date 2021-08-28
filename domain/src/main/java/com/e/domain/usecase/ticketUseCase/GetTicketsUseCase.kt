package com.e.domain.usecase.ticketUseCase

import com.e.domain.repository.TicketRepo
import javax.inject.Inject

class GetTicketsUseCase @Inject constructor(private val ticketRepo: TicketRepo) {

    suspend fun execute(id: String) = ticketRepo.getTickets(id)

}