package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.e.data.entity.local.Errors
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class Token(

    @Json(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @Json(name = "accessToken")
    var accessToken : String?,

    @Json(name = "tokenType")
    var tokenType:String?,

    @Json(name = "expires")
    var expires:String?,

    @Json(name = "user")
    var user: User?,

    @Json(name = "accessResult")
    var result: Boolean?,

    @Json(name = "errors")
    var errors: Errors?
)
