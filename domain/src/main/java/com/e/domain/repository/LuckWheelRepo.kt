package com.e.domain.repository

import com.e.data.entity.LuckRequest
import com.e.data.entity.remote.LuckSlice


interface LuckWheelRepo {

    suspend fun getSlices(): MutableList<LuckSlice>

    suspend fun checkUserLuck(): Boolean

    suspend fun createUserLuck(coin: String): LuckRequest
}