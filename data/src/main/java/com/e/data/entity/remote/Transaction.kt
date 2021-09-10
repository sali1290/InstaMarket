package com.e.data.entity.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Transaction(
    @Json(name = "id")
    var id: Int?,

    @Json(name = "ids")
    var ids: String?,

    @Json(name = "uid")
    var uid: String?,

    @Json(name = "type")
    var type: String?,

    @Json(name = "transaction_id")
    var transactionId: Float?,

    @Json(name = "amount")
    var amount: Float?,

    @Json(name = "status")
    var status: String?,

    @Json(name = "created")
    var created: Int?,

    @Json(name = "log")
    var log: String?,

    @Json(name = "systemi")
    var systemi: String?,

    @Json(name = "payer_email")
    var payerEmail: String?,

    @Json(name = "txn_fee")
    var txnFee: String?,

    @Json(name = "note")
    var note: String?,


    )