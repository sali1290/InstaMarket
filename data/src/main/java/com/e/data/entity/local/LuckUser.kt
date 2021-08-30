package com.e.data.entity.local

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class LuckUser(

    var id: Int?,

    var coin: String?,

    var date: Date?,

    var user_id: Int?
)
