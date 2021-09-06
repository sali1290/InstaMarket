package com.e.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class RegisterTypeConverter {
    fun converter(
        email: String?,
        phone: String?,
        firstName: String?,
        lastName: String?,
        userName: String?,
        password: String?,
        confirmPassword: String?
    ): RegisterRequest {
        return RegisterRequest(
            email,
            phone,
            firstName,
            lastName,
            userName,
            password,
            confirmPassword
        )
    }
}

@JsonClass(generateAdapter = true)
data class RegisterRequest(
    var email: String?,
    var phone: String?,
    var firstName: String?,
    var lastName: String?,
    var userName: String?,
    var password: String?,
    var confirmPassword: String?
)