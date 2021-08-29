package com.e.domain.models

data class TicketModel(

    val id: Int?,

    val changed: Any?,

    val created: Any?,

    val description: String?,

    val ids: Any?,

    val messages: ErrorsModel?,

    val status: String?,

    val subject: String?,

    val uid: String?
)