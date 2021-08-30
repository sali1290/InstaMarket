package com.e.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class LoginTypeConverter {
    fun converter(email: String? , password: String?): LoginRequest{
        return LoginRequest(email , password)
    }

}
@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "email")
    var email:String?,
    @Json(name = "password")
    var password: String?
)