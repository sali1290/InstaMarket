package com.e.data.entity.remote

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
    var transactionId: String?,

    @Json(name = "amount")
    var amount: String?,

    @Json(name = "status")
    var status: String?,

    @Json(name = "created")
    var created: String?,

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
