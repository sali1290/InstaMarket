package com.e.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity
data class User(

    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    val id: Int?

) : Parcelable
