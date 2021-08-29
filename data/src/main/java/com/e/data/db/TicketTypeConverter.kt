package com.e.data.db

import androidx.room.TypeConverter
import com.e.data.entity.local.Errors
import com.e.data.entity.local.Ticket
import com.e.data.entity.local.User
import org.json.JSONObject

class TicketTypeConverter {
    @TypeConverter
    fun fromUser(ticket: Ticket): String {
        return JSONObject().apply {
            put("id", ticket.id)
            put("changed", ticket.changed)
            put("created", ticket.created)
            put("created", ticket.description)
            put("ids", ticket.ids)
            put("messages", ticket.messages)
            put("status", ticket.status)
            put("subject", ticket.subject)
            put("uid", ticket.uid)
        }.toString()
    }

    @TypeConverter
    fun toSource(user: String): Ticket {
        val json = JSONObject(user)
        return Ticket(
            json.getInt("id"),
            json.getString("changed"),
            json.getString("created"),
            json.getString("created"),
            json.getString("ids"),
            json.get("messages") as Errors?,
            json.getString("status"),
            json.getString("subject"),
            json.getString("uid")
        )
    }
}