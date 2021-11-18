package com.e.data.repository

import com.e.data.api.UserBankInfoTypeConverter
import com.e.data.api.UserInfoTypeConverter
import com.e.data.mapper.BlogMapper
import com.e.data.repository.userDataSource.remote.UserRemoteDataSource
import com.e.data.utile.NetWorkHelper
import com.e.domain.models.BlogModel
import com.e.domain.models.UserModel
import com.e.domain.repository.UserRepo
import dagger.Lazy
import java.io.IOException
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val netWorkHelper: NetWorkHelper,
    private val blogMapper: Lazy<BlogMapper>
) : UserRepo {


    override suspend fun updateUser(): UserModel? {
        val user: UserModel? = null
        return user!!
    }

    @Throws(IOException::class)
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

    @Throws(IOException::class)
    override suspend fun updateUserBankInfo(
        shcart: String?,
        shshaba: String?,
        bankName: String?
    ): Boolean {
        val userBankInfoConverter =
            UserBankInfoTypeConverter().converter(shcart, shshaba, bankName)
        val request = userRemoteDataSource.updateUserBankInfoFromRemote(userBankInfoConverter)

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

    @Throws(IOException::class)
    override suspend fun updateUserInfo(
        firstName: String?,
        lastName: String?,
        email: String?,
        username: String?,
        phone: String?,
//        birthday: String?,
//        education: String?,
//        marry: String?,
//        sex: String?
    ): Boolean {
        val userInfoConverter =
            UserInfoTypeConverter().converter(
                firstName,
                lastName,
                email,
                username,
                phone,
//                birthday,
//                education,
//                marry,
//                sex
            )
        val request = userRemoteDataSource.updateUserInfoFromRemote(userInfoConverter)

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