package com.e.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class UserInfoTypeConverter {
    fun converter(
        firstName: String?,
        lastName: String?,
        email: String?,
        username: String?,
        phone: String?,
//        birthday: String?,
//        education: String?,
//        marry: String?,
//        sex: String?
    ): UserInfoRequest {
        return UserInfoRequest(
            firstName,
            lastName,
            email,
            username,
            phone,
//            birthday,
//            education,
//            marry,
//            sex
        )
    }
}

@JsonClass(generateAdapter = true)
data class UserInfoRequest(
    @Json(name = "first_name")
    var firstName: String?,

    @Json(name = "last_name")
    var lastName: String?,

    @Json(name = "email")
    var email: String?,

    @Json(name = "username")
    var username: String?,

    @Json(name = "phone")
    var phone: String?,

//    @Json(name = "birthday")
//    var birthday: String?,
//
//    @Json(name = "education")
//    var education: String?,
//
//    @Json(name = "marry")
//    var marry: String?,
//
//    @Json(name = "sex")
//    var sex: String?,
)