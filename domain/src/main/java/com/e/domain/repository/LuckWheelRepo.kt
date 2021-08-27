package com.e.domain.repository

import com.e.domain.models.LuckRequestModel
import com.e.domain.models.LuckSliceModel


interface LuckWheelRepo {

    suspend fun getSlices(): MutableList<LuckSliceModel>

    suspend fun checkUserLuck(): Boolean

    suspend fun createUserLuck(coin: String): LuckRequestModel
}