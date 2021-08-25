package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
@Entity
data class Transaction(

    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    var id: Int?,

    @Json(name = "ids")
    var ids: String?,

    @Json(name = "uid")
    var uid: String?,

    @Json(name = "type")
    var type: String?,

    @Json(name = "transactionId")
    var transactionId: Float?,

    @Json(name = "amount")
    var amount: Float?,

    @Json(name = "status")
    var status: String?,

    @Json(name = "created")
    var created: Int?,

    @Json(name = "log")
    var log: String?,

    @Json(name = "created")
    var systemi: String?,

    @Json(name = "payerEmail")
    var payerEmail: String?,

    @Json(name = "txnFee")
    var txnFee: String?,

    @Json(name = "note")
    var note: String?,


    )
