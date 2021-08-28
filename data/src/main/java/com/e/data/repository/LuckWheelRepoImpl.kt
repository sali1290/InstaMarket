package com.e.data.repository

import com.e.data.mapper.LuckRequestMapper
import com.e.data.mapper.LuckSliceMapper
import com.e.data.repository.luckWheelDataSource.local.LuckWheelLocalDataSource
import com.e.data.repository.luckWheelDataSource.remote.LuckWheelRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.LuckRequestModel
import com.e.domain.models.LuckSliceModel
import com.e.domain.repository.LuckWheelRepo
import java.io.IOException
import javax.inject.Inject
import kotlin.properties.Delegates

class LuckWheelRepoImpl @Inject constructor(
    private val luckWheelRemoteDataSource: LuckWheelRemoteDataSource,
    private val luckWheelLocalDataSource: LuckWheelLocalDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val luckSliceMapper: dagger.Lazy<LuckSliceMapper>,
    private val luckRequestMapper: dagger.Lazy<LuckRequestMapper>
) : LuckWheelRepo {

    @Throws(IOException::class)
    override suspend fun getSlices(): MutableList<LuckSliceModel> {
        lateinit var sliceList: MutableList<LuckSliceModel>
        if (netWorkHelper.isNetworkConnected()) {
            if (luckWheelRemoteDataSource.getSlicesFromRemote().isSuccessful &&
                luckWheelRemoteDataSource.getSlicesFromRemote().body() != null
            ) {
                for (i in 0..luckWheelRemoteDataSource.getSlicesFromRemote().body()!!.size) {
                    sliceList[i] = luckWheelRemoteDataSource.getSlicesFromRemote().body()!![i].let {
                        luckSliceMapper.get().toMapper(it)
                    }
                }
                return sliceList
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun checkUserLuck(): Boolean {
        var luck by Delegates.notNull<Boolean>()
        if (netWorkHelper.isNetworkConnected()) {
            if (luckWheelRemoteDataSource.getUserLuckFromRemote().isSuccessful &&
                luckWheelRemoteDataSource.getUserLuckFromRemote().body() != null
            ) {
                luck = luckWheelRemoteDataSource.getUserLuckFromRemote().body()!!
                return luck
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    @Throws(IOException::class)
    override suspend fun createUserLuck(coin: String): LuckRequestModel {
        lateinit var luckRequest: LuckRequestModel
        if (netWorkHelper.isNetworkConnected()) {
            if (luckWheelRemoteDataSource.createLuckFromRemote(coin).isSuccessful &&
                luckWheelRemoteDataSource.createLuckFromRemote(coin).body() != null
            ) {
                val response = luckWheelRemoteDataSource.createLuckFromRemote(coin).body()
                luckRequest = response.let {
                    luckRequestMapper.get().toMapper(it!!)
                }
                luckWheelLocalDataSource.saveLuckFromDB(response!!)
                return luckRequest
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

}