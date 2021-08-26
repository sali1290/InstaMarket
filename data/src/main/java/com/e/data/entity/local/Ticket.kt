package com.e.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ticket(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    val changed: Any?,

    val created: Any?,

    val description: String?,

    val ids: Any?,

    val messages: List<Any>?,

    val status: String?,

    val subject: String?,

    val uid: String?
)