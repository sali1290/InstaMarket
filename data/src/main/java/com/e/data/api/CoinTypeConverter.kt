package com.e.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class CoinTypeConverter {

    fun converter(coin: String?): CoinRequest {
        return CoinRequest(coin)
    }
}

@JsonClass(generateAdapter = true)
data class CoinRequest(
    @Json(name = "coin")
    var coin: String?,
)
