package com.e.data.repository

import com.e.domain.models.LuckRequestModel
import com.e.domain.models.LuckSliceModel
import com.e.domain.repository.LuckWheelRepo

class LuckWheelRepoImpl: LuckWheelRepo {
    override suspend fun getSlices(): MutableList<LuckSliceModel> {
        TODO("Not yet implemented")
    }

    override suspend fun checkUserLuck(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun createUserLuck(coin: String): LuckRequestModel {
        TODO("Not yet implemented")
    }
}