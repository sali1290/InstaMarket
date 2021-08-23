package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class Order(

    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    var id: Int?,

    @Json(name = "name")
    var name: String?,

    @Json(name = "amount")
    var amount: String?,

    @Json(name = "rule")
    var rule: String?,

    @Json(name = "category_id")
    var category_id: Int?,

    )
