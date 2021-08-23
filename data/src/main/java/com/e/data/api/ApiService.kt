package com.e.data.api

import com.e.data.entity.*
import com.e.data.entity.local.Order
import com.e.data.entity.local.Ticket
import com.e.data.entity.Category
import com.e.data.entity.Service
import com.e.data.entity.Site
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

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
    suspend fun createLuck(): Response<LuckRequest>


    //info api
    @POST("/general/categories")
    suspend fun getCategory(): Response<MutableList<Category>>

    @POST("/general/faqs")
    suspend fun getFaq(): Response<MutableList<Faq>>

    @POST("/general/services")
    suspend fun getService(): Response<MutableList<Service>>

    @POST("/general/sites")
    suspend fun getSites(): Response<MutableList<Site>>

    @POST("/general/banners")
    suspend fun getBanners(): Response<MutableList<Banner>>

    @POST("/general/api")
    suspend fun getApi(): Response<MutableList<Api>>

    @POST("/general/agents")
    suspend fun getAgents(): Response<MutableList<Agents>>

    @POST("/general/news")
    suspend fun getNews(): Response<MutableList<News>>


    //user api
    @POST("/user/update")
    suspend fun updateUser(): Response<Boolean>

    @POST("/user/checkVerify")
    suspend fun checkUserIsVerify(): Response<Boolean>

    @POST("/user/authenticate")
    suspend fun verifyUser(): Response<Token>

    @POST("/user/sendVerifyCode")
    suspend fun sendVerify(): Response<Token>


    //order api
    @GET("/product")
    suspend fun createOrder(): Response<OrderRequest>

    @GET("/productList")
    suspend fun getUserOrders(): Response<MutableList<Order>>


    //transaction api
    @POST("/transaction/create")
    suspend fun createTransaction(): Response<String>

    @POST("/transaction/get")
    suspend fun getUserTransaction(): Response<MutableList<Transaction>>


    //ticket api
    @POST("/ticket/create")
    suspend fun createTicket(): Response<TicketRequest>

    @POST("/ticket/get")
    suspend fun getTicket(): Response<MutableList<Ticket>>


}