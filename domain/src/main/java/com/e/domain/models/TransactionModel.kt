package com.e.domain.models

import java.util.*

data class TransactionModel(

    var id: Int?,

    var amount: Float?,

    var date: Date?,

    var origin: String?,

    var destination: String?,

    var user_id: Int?

)
