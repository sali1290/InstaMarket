package com.e.data.db

import androidx.room.TypeConverter
import com.e.data.entity.local.Errors
import com.e.data.entity.local.User
import org.json.JSONObject

class ErrorTypeConverter {
    @TypeConverter
    fun fromError(error: Errors?): String {
        return JSONObject().apply {
            put("email", error?.email)
            put("password", error?.password)
        }.toString()
    }

    @TypeConverter
    fun toSource(user: String): Errors {
        val json = JSONObject(user)
        return Errors(
            json.getString("email"), json.getString("password")
        )
    }
}