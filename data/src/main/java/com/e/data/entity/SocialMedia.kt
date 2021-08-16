package com.e.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SocialMedia(

    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    var name: String?,

)
