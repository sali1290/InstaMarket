package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.e.data.entity.local.Errors
import com.e.data.entity.local.Order
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class OrderRequest(

    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    var id : Int?,

    @Json(name = "order")
    var order: Order?,

    @Json(name = "result")
    var result: Boolean?,

    @Json(name = "message")
    var message: String?,

    @Json(name = "errors")
    var errors: Errors?
)