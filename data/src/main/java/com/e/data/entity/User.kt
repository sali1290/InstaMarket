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

    @Json(name = "name")
    var name : String?,

    @Json(name = "phone")
    var phone : String?,

    @Json(name = "email")
    var email : String?,

    @Json(name = "birth")
    var birth : Date?,

    @Json(name = "tel_id")
    var tel_id : String?,

    @Json(name = "insta_id")
    var insta_id : String?,

    @Json(name = "address")
    var address : String?,

    @Json(name = "sex")
    var sex : String?,

    @Json(name = "martialStatus")
    var martialStatus : String?,

    @Json(name = "educate")
    var educate : String?,

    @Json(name = "stock")
    var stock : Float?,

    @Json(name = "image")
    var image : String?,

    @Json(name = "cardNumber")
    var cardNumber : String?,

    @Json(name = "shabaNumbmer")
    var shabaNumbmer : String?,

    @Json(name = "bankName")
    var bankName : String?,

    @Json(name = "ownerName")
    var ownerName : String?,


    )
