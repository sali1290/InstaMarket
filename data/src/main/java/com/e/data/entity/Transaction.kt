package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*


@JsonClass(generateAdapter = true)
@Entity
data class Transaction(

    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    var id: Int?,

    @Json(name = "amount")
    var amount: Float?,

    @Json(name = "date")
    var date: Date?,

    @Json(name = "origin")
    var origin: String?,

    @Json(name = "destination")
    var destination: String?,

    @Json(name = "user_id")
    var user_id: Int?

)
