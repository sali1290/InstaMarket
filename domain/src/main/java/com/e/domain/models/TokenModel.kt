package com.e.domain.models

data class TokenModel(

    var id: Int?,

    var accessToken : String?,

    var tokenType:String?,

    var expires:String?,

    var user: UserModel?,

    var result: Boolean?,

    var errors: ErrorsModel?
)
