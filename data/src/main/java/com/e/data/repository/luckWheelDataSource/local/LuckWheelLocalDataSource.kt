package com.e.data.repository.luckWheelDataSource.local

import com.e.data.entity.LuckRequest

interface LuckWheelLocalDataSource {

    suspend fun saveLuckFromDB(luckRequest: LuckRequest)

    suspend fun deleteLuckFromDB()

    suspend fun getLuckListFromDB(): MutableList<LuckRequest>

}