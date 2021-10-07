package com.e.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class CreateTransactionConverter {
    fun converter(amount: String?, type: String?): CreateTransactionRequest {
        return CreateTransactionRequest(amount, type)
    }
}

@JsonClass(generateAdapter = true)
data class CreateTransactionRequest(
    @Json(name = "amount")
    var amount: String?,

    @Json(name = "type")
    var type: String?
)
