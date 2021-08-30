package com.e.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Ticket(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    val changed: String?,

    val created: String?,

    val description: String?,

    val ids: String?,

    val messages: Errors?,

    val status: String?,

    val subject: String?,

    val uid: String?
)