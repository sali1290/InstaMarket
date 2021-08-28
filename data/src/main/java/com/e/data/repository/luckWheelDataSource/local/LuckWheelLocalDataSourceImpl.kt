package com.e.data.repository.luckWheelDataSource.local

import com.e.data.dao.LuckRequestDao
import com.e.data.entity.LuckRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LuckWheelLocalDataSourceImpl @Inject constructor(private val luckRequestDao: LuckRequestDao): LuckWheelLocalDataSource {
    override suspend fun saveLuckFromDB(luckRequest: LuckRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            luckRequestDao.saveLuck(luckRequest)
        }
    }

    override suspend fun deleteLuckFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            luckRequestDao.deleteLuckHistory()
        }
    }

    override suspend fun getLuckListFromDB(): MutableList<LuckRequest> {
        return luckRequestDao.getLuckList()
    }
}