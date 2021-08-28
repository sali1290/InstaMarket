package com.e.domain.usecase.ticketUseCase

import com.e.domain.repository.TicketRepo
import javax.inject.Inject

class CreateTicketUseCase @Inject constructor(private val ticketRepo: TicketRepo) {

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