package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.e.data.entity.local.Errors
import com.e.data.entity.local.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class RegisterResponse(
    @Json(name = "id")
    @PrimaryKey(autoGenerate = true)
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

    @Json(name = "password_confirmation")
    var passwordConfirmation: String?,

    @Json(name = "errors")
    var errors: Errors?,
)
