package com.e.data.repository

import com.e.data.api.CoinTypeConverter
import com.e.data.api.GetTransactionConverter
import com.e.data.mapper.LuckRequestMapper
import com.e.data.mapper.LuckSliceMapper
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
    private val netWorkHelper: NetWorkHelper,
    private val luckSliceMapper: dagger.Lazy<LuckSliceMapper>,
    private val luckRequestMapper: dagger.Lazy<LuckRequestMapper>,
) : LuckWheelRepo {

    @Throws(IOException::class)
    override suspend fun getSlices(): MutableList<LuckSliceModel> {
        lateinit var sliceList: MutableList<LuckSliceModel>
        if (netWorkHelper.isNetworkConnected()) {
            if (luckWheelRemoteDataSource.getSlicesFromRemote().isSuccessful &&
                luckWheelRemoteDataSource.getSlicesFromRemote().body() != null
            ) {
                val response = luckWheelRemoteDataSource.getSlicesFromRemote().body()
                sliceList = response!!.luckSliceList.map {
                    luckSliceMapper.get().toMapper(it)
                }.toMutableList()
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
        val request = luckWheelRemoteDataSource.getUserLuckFromRemote()
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful && request.body() != null) {
                luck = request.body()!!
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
        val coinRequest = CoinTypeConverter().converter(coin)
        val request = luckWheelRemoteDataSource.createLuckFromRemote(coinRequest)
        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful && request.body() != null) {
                val response = request.body()
                luckRequest = response.let {
                    luckRequestMapper.get().toMapper(it!!)
                }
                return luckRequest
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

}