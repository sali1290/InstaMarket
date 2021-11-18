package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegisterResponse(
    @Json(name = "id")
    var id: Int?,

    @Json(name = "access_token")
    var accessToken: String?,

    @Json(name = "token_type")
    var tokenType: String?,

    @Json(name = "expires_at")
    var expires: String?,

    @Json(name = "user")
    var user: User?,

    @Json(name = "result")
    var result: Boolean?,

    @Json(name = "message")
    var message: String?,

    @Json(name = "errors")
    var errors: Errors?

)
