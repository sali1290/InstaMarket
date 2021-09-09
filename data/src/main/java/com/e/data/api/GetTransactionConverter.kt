package com.e.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class GetTransactionConverter {
    fun converter(id: String?): TransactionRequest {
        return TransactionRequest(id)
    }

}

@JsonClass(generateAdapter = true)
data class TransactionRequest(
    @Json(name = "id")
    var id: String?,
)