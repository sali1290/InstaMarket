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
            put("username", error?.username)
            put("phone", error?.phoen)
        }.toString()
    }

    @TypeConverter
    fun toSource(user: String): Errors {
        val json = JSONObject(user)
        return Errors(
            json.get("email") as List<String>?, json.get("password") as List<String>?,
            json.get("username") as List<String>?, json.get("phone") as List<String>?
        )
    }
}