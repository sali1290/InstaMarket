package com.e.data.entity.localEntity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

data class LuckUser(
    var id: Int?,

    var coin: String?,

    var date: Date?,

    var user_id: Int?
)
