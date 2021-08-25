package com.e.domain.models

data class OrderRequestModel(


    var id : Int?,

    var order: OrderModel?,

    var result: Boolean?,

    var message: String?,

    var errors: ErrorsModel?
)