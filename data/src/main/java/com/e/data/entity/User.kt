package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
@Entity
data class User(

    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    val id: Int?,

    @Json(name = "ids")
    val ids: Int?,

    @Json(name = "role")
    var role: String?,

    @Json(name = "loginType")
    var loginType: String?,

    @Json(name = "firstName")
    var firstName : String?,

    @Json(name = "lastName")
    var lastName : String?,

    @Json(name = "email")
    var email : String?,

    @Json(name = "userName")
    var userName : String?,

    @Json(name = "phone")
    var phone : String?,

    @Json(name = "verifyPhone")
    var verifyPhone : String?,

    @Json(name = "timeZone")
    var timeZone : String?,

    @Json(name = "moreInformation")
    var moreInformation : String?,

    @Json(name = "settings")
    var settings : String?,

    @Json(name = "desc")
    var desc : String?,

    @Json(name = "balance")
    var balance : String?,

    @Json(name = "customRate")
    var customRate : String?,

    @Json(name = "apiKey")
    var apiKey : String?,

    @Json(name = "spent")
    var spent : String?,

    @Json(name = "activationKey")
    var activationKey : String?,

    @Json(name = "resetKey")
    var resetKey : String?,

    @Json(name = "historyIp")
    var historyIp : String?,

    @Json(name = "status")
    var status : String?,

    @Json(name = "changed")
    var changed : String?,

    @Json(name = "created")
    var created : String?,

    @Json(name = "ref")
    var ref : String?,

    @Json(name = "profitRate")
    var profitRate : String?,

    @Json(name = "alfa")
    var alfa : String?,

    @Json(name = "minharvest")
    var minharvest : String?,

    @Json(name = "cardNumber")
    var cardNumber : String?,

    @Json(name = "shNumber")
    var shNumber : String?,

    @Json(name = "accountName")
    var accountName : String?,

    @Json(name = "bankName")
    var bankName : String?,

    @Json(name = "verifyBank")
    var verifyBank : String?,

    @Json(name = "verifyMore")
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

    @Json(name = "isBlock")
    var isBlock : String?,

    @Json(name = "roleUser")
    var roleUser : String?,

    @Json(name = "agentDate")
    var agentDate : String?,

    @Json(name = "agentId")
    var agentId : String?,

    @Json(name = "agentExpair")
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
