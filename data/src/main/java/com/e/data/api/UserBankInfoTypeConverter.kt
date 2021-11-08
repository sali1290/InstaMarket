package com.e.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class UserBankInfoTypeConverter {
    fun converter(
        shcart: String?,
        shshaba: String?,
        bankName: String?,
    ): UserBankInfoRequest {
        return UserBankInfoRequest(
            shcart,
            shshaba,
            bankName,
        )
    }
}

@JsonClass(generateAdapter = true)
data class UserBankInfoRequest(
    @Json(name = "shcart")
    var shcart: String?,

    @Json(name = "shshaba")
    var shshaba: String?,

    @Json(name = "Name_bank")
    var bankName: String?,
    )
