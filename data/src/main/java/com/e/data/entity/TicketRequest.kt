package com.e.data.entity

import androidx.room.PrimaryKey
import com.e.data.entity.local.Ticket
import com.squareup.moshi.Json

data class TicketRequest(

    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @Json(name = "result")
    var result: Boolean?,

    @Json(name = "ticket")
    var ticket: Ticket?,

    @Json(name = "message")
    var message: String?

)
