package com.e.data.api

import com.e.data.entity.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {

    //login api
    @POST("/auth/login")
    suspend fun login():Response<Token>

    @POST("/auth/register")
    suspend fun register():Response<Token>

    @POST("/auth/user")
    suspend fun getUser():Response<String>

    @POST("/auth/logout")
    suspend fun logout():Response<String>

    //luck api
    @POST("/luck/slices")
    suspend fun getLuckSlice(): Response<MutableList<LuckSlice>>

    @POST("/luck/check")
    suspend fun checkUserLuck(): Response<Boolean>

    @POST("/luck/store")
    suspend fun createLuck(): Response<Luck>

    //info api
    @POST("/general/categories")
    suspend fun getCategory(): Response<LuckSlice>

    @POST("/general/faqs")
    suspend fun getFaq(): Response<LuckSlice>

    @POST("/general/services")
    suspend fun getService(): Response<LuckSlice>

    @POST("/general/sites")
    suspend fun getSites(): Response<LuckSlice>

    @POST("/general/banners")
    suspend fun getBanners(): Response<LuckSlice>

    @POST("/general/api")
    suspend fun getApi(): Response<LuckSlice>

    @POST("/general/agents")
    suspend fun getAgents(): Response<LuckSlice>

    @POST("/general/news")
    suspend fun getNews(): Response<LuckSlice>

    //user api
    @POST("/user/update")
    suspend fun updateUser(): Response<LuckSlice>

    @POST("/user/checkVerify")
    suspend fun checkUserIsVerify(): Response<LuckSlice>

    @POST("/user/authenticate")
    suspend fun verifyUser(): Response<LuckSlice>

    @POST("/user/sendVerifyCode")
    suspend fun sendVerify(): Response<LuckSlice>


    //transaction api
    @POST("/transaction/create")
    suspend fun createTransaction(): Response<LuckSlice>

    @POST("/transaction/get")
    suspend fun getUserTransaction(): Response<LuckSlice>

    //ticket api
    @POST("/ticket/create")
    suspend fun createTicket(): Response<LuckSlice>

    @POST("/ticket/get")
    suspend fun getTicket(): Response<LuckSlice>

    //order api
    @GET("/product")
    suspend fun getSingleOrder(): Response<Order>

    @GET("/productList")
    suspend fun getOrderList(): Response<List<Order>>

}