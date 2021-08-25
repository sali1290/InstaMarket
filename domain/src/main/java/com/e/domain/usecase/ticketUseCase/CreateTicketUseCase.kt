package com.e.domain.usecase.ticketUseCase

import com.e.domain.repository.TicketRepo

class CreateTicketUseCase(private val ticketRepo: TicketRepo) {

    suspend fun execute(
        subject: String,
        orderId: String,
        type: String,
        description: String
    ) = ticketRepo.createTicket(
        subject,
        orderId,
        type,
        description
    )

}