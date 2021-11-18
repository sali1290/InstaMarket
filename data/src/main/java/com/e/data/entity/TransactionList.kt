package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransactionList(
    @Json(name = "data")
     val transactionList: MutableList<Transaction>
)
