package com.e.data.repository

import com.e.data.api.UserBankInfoTypeConverter
import com.e.data.mapper.BlogMapper
import com.e.data.mapper.UserMapper
import com.e.data.repository.userDataSource.local.UserLocalDataSource
import com.e.data.repository.userDataSource.remote.UserRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.BlogModel
import com.e.domain.models.UserModel
import com.e.domain.repository.UserRepo
import java.io.IOException
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource,
    private val userMapper: dagger.Lazy<UserMapper>,
    private val netWorkHelper: NetWorkHelper,
    private val blogMapper: dagger.Lazy<BlogMapper>
) :
    UserRepo {

    @Throws(IOException::class)
    override suspend fun getUser(): UserModel {
        lateinit var user: UserModel
        if (userLocalDataSource.getUserFromDB().id != null) {
            userLocalDataSource.getUserFromDB().let {
                user = userMapper.get().toMapper(it)
            }
            return user
        } else {
            throw IOException("Sorry!!")
        }


    }

    override suspend fun updateUser(): UserModel? {
        val user: UserModel? = null
        return user!!
    }

    override suspend fun getBlogs(): MutableList<BlogModel> {
        lateinit var blogList: MutableList<BlogModel>
        val request = userRemoteDataSource.getBlogs()

        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful &&
                request.body() != null
            ) {
                val response = request.body()
                blogList = response!!.blogListL.map {
                    blogMapper.get().toMapper(it)
                }.toMutableList()
                return blogList
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }

    override suspend fun updateUserBankInfo(
        shcart: String?,
        shshaba: String?,
        bankName: String?
    ): Boolean {
        val userBankInfoConverter =
            UserBankInfoTypeConverter().converter(shcart, shshaba, bankName)
        val request = userRemoteDataSource.updateUserFromRemote(userBankInfoConverter)

        if (netWorkHelper.isNetworkConnected()) {
            if (request.isSuccessful &&
                request.body() != null
            ) {
                val answer = request.body()
                return answer!!
            } else {
                throw IOException("Server is Not Responding")
            }
        } else {
            throw IOException("No Internet Connection")
        }
    }
}