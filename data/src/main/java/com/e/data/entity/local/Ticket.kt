package com.e.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ticket(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    val changed: String?,

    val created: String?,

    val description: String?,

    val ids: String?,

    val messages: List<String>?,

    val status: String?,

    val subject: String?,

    val uid: String?
)