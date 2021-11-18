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
        passwordConfirmation: String?
    ): RegisterRequest {
        return RegisterRequest(
            email,
            phone,
            firstName,
            lastName,
            userName,
            password,
            passwordConfirmation
        )
    }
}

@JsonClass(generateAdapter = true)
data class RegisterRequest(
    @Json(name = "email")
    var email: String?,

    @Json(name = "phone")
    var phone: String?,

    @Json(name = "first_name")
    var firstName: String?,

    @Json(name = "last_name")
    var lastName: String?,

    @Json(name = "username")
    var userName: String?,

    @Json(name = "password")
    var password: String?,

    @Json(name = "password_confirmation")
    var passwordConfirmation: String?,


    )