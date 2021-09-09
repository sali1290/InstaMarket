package com.e.data.entity

import com.e.data.entity.remote.Transaction
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransactionList(
    @Json(name = "data")
     val transactionList: MutableList<Transaction>
)
