package com.e.data.db

import androidx.room.TypeConverter
import com.e.data.entity.local.Errors
import com.e.data.entity.local.LuckUser
import com.e.data.entity.local.Ticket
import org.json.JSONObject
import java.util.*

class LuckUserTypeConverter {
    @TypeConverter
    fun fromUser(ticket: LuckUser): String {
        return JSONObject().apply {
            put("id", ticket.id)
            put("coin", ticket.coin)
            put("date", ticket.date)
            put("user_id", ticket.user_id)
        }.toString()
    }

    @TypeConverter
    fun toSource(user: String): LuckUser {
        val json = JSONObject(user)
        return LuckUser(
            json.getInt("id"),
            json.getString("coin"),
            json.get("date") as Date?,
            json.getInt("user_id")
        )
    }
}