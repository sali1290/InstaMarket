package com.e.data.api

import com.e.data.entity.*
import com.e.data.entity.local.Order
import com.e.data.entity.local.Ticket
import com.e.data.entity.remote.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    //Enter app api
    @POST("auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<Token>

    @POST("auth/register")
    suspend fun register(
        @Body registerRequest: RegisterRequest
    ): Response<Token>

    @POST("auth/user")
    @FormUrlEncoded
    suspend fun getUser(
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("user_name") userName: String,
        @Field("password") password: String
    ): Response<String>

    @POST("auth/logout")
    @FormUrlEncoded
    suspend fun logout(
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("user_name") userName: String,
        @Field("password") password: String
    ): Response<String>


    //luck api
    @POST("luck/slices")
    suspend fun getLuckSlice(@Header("Authorization") accessToken: String): Response<LuckSliceList>

    @POST("luck/check")
    suspend fun checkUserLuck(@Header("Authorization") accessToken: String): Response<Boolean>

    @POST("luck/store")
    suspend fun createLuck(
        @Header("Authorization") accessToken: String,
        @Body coin: String
    ): Response<LuckRequest>


    //info api
    @POST("general/categories")
    suspend fun getCategory(@Header("Authorization") accessToken: String): Response<CategoryList>

    @POST("general/faqs")
    @FormUrlEncoded
    suspend fun getFaq(): Response<MutableList<Faq>>

    @POST("general/services")
    suspend fun getService(@Header("Authorization") accessToken: String): Response<ServiceList>

    @POST("general/sites")
    suspend fun getSites(): Response<MutableList<Site>>

    @POST("general/banners")
    suspend fun getBanners(@Header("Authorization") accessToken: String): Response<BannerList>

    @POST("general/api")
    suspend fun getApi(@Header("Authorization") accessToken: String): Response<ApiList>

    @POST("general/agents")
    suspend fun getAgents(@Header("Authorization") accessToken: String): Response<AgentList>

    @POST("general/news")
    suspend fun getNews(@Header("Authorization") accessToken: String): Response<NewsList>


    //user api
    @POST("user/update")
    @FormUrlEncoded
    suspend fun updateUser(
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String
    ): Response<Boolean>

    @POST("user/checkVerify")
    @FormUrlEncoded
    suspend fun checkUserIsVerify(): Response<Boolean>

    @POST("user/authenticate")
    @FormUrlEncoded
    suspend fun verifyUser(@Field("code") code: String): Response<Token>

    @POST("user/sendVerifyCode")
    @FormUrlEncoded
    suspend fun sendVerify(): Response<Token>


    //order api
    @POST("order/create")
    @FormUrlEncoded
    suspend fun createOrder(
        @Field("category_id") categoryId: String,
        @Field("service_id") serviceId: String,
        @Field("quantity") quantity: String,
        @Field("link") link: String
    ): Response<OrderRequest>

    @POST("order/get")
    @FormUrlEncoded
    suspend fun getUserOrders(@Field("id") id: String): Response<MutableList<Order>>


    //transaction api
    @POST("transaction/create")
    @FormUrlEncoded
    suspend fun createTransaction(
        @Field("amount") amount: String,
        @Field("type") type: String
    ): Response<String>

    @POST("transaction/get")
    @FormUrlEncoded
    suspend fun getUserTransaction(
        @Header("Authorization") accessToken: String,
        @Field("id") id: String?
    ): Response<TransactionList>


    //ticket api
    @POST("ticket/create")
    @FormUrlEncoded
    suspend fun createTicket(
        @Field("subject") subject: String,
        @Field("order_id") order_id: String,
        @Field("type") type: String,
        @Field("description") description: String
    ): Response<TicketRequest>

    @POST("ticket/get")
    @FormUrlEncoded
    suspend fun getTicket(@Field("id") id: String): Response<MutableList<Ticket>>


}