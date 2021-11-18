package com.e.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(

    @Json(name = "id")
    val id: Int?,

    @Json(name = "ids")
    val ids: String?,

    @Json(name = "role")
    var role: String?,

    @Json(name = "login_type")
    var loginType: String?,

    @Json(name = "first_name")
    var firstName : String?,

    @Json(name = "last_name")
    var lastName : String?,

    @Json(name = "email")
    var email : String?,

    @Json(name = "username")
    var userName : String?,

    @Json(name = "phone")
    var phone : String?,

    @Json(name = "verify_phone")
    var verifyPhone : String?,

    @Json(name = "time_zone")
    var timeZone : String?,

    @Json(name = "more_information")
    var moreInformation : String?,

    @Json(name = "settings")
    var settings : String?,

    @Json(name = "desc")
    var desc : String?,

    @Json(name = "balance")
    var balance : String?,

    @Json(name = "custom_rate")
    var customRate : String?,

    @Json(name = "api_key")
    var apiKey : String?,

    @Json(name = "spent")
    var spent : String?,

    @Json(name = "activation_key")
    var activationKey : String?,

    @Json(name = "reset_key")
    var resetKey : String?,

    @Json(name = "history_ip")
    var historyIp : String?,

    @Json(name = "status")
    var status : String?,

    @Json(name = "changed")
    var changed : String?,

    @Json(name = "created")
    var created : String?,

    @Json(name = "ref")
    var ref : String?,

    @Json(name = "profit_rate")
    var profitRate : String?,

    @Json(name = "alfa")
    var alfa : String?,

    @Json(name = "minharvest")
    var minharvest : String?,

    @Json(name = "shcart")
    var cardNumber : String?,

    @Json(name = "shshaba")
    var shNumber : String?,

    @Json(name = "account_name")
    var accountName : String?,

    @Json(name = "Name_bank")
    var bankName : String?,

    @Json(name = "verify_bank")
    var verifyBank : String?,

    @Json(name = "verify_more")
    var verifyMore : String?,

    @Json(name = "birthday")
    var birthday : String?,

    @Json(name = "education")
    var education : String?,

    @Json(name = "marry")
    var marry : String?,

    @Json(name = "sex")
    var sex : String?,

    @Json(name = "avatar")
    var avatar : String?,

    @Json(name = "is_block")
    var isBlock : String?,

    @Json(name = "role_user")
    var roleUser : String?,

    @Json(name = "agent_date")
    var agentDate : String?,

    @Json(name = "agent_id")
    var agentId : String?,

    @Json(name = "agent_expair")
    var agentExpair : String?,

    @Json(name = "meliCard")
    var meliCard : String?,

    @Json(name = "domin")
    var domin : String?,

    @Json(name = "subdomin")
    var subdomin : String?,

    @Json(name = "flagdomin")
    var flagdomin : String?,


    )
