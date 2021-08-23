package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class Faq(

    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    val id: Int?,

    @Json(name = "answer")
    val answer: String?,

    @Json(name = "changed")
    val changed: String?,

    @Json(name = "created")
    val created: String?,

    @Json(name = "ids")
    val ids: String?,

    @Json(name = "question")
    val question: String?,

    @Json(name = "sort")
    val sort: String?,

    @Json(name = "status")
    val status: String?,

    @Json(name = "uid")
    val uid: String?
)