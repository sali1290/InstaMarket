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
    @FormUrlEncoded
    @Headers("Accept:application/json")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<Token>

    @POST("auth/register")
    @FormUrlEncoded
    suspend fun register(
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("user_name") userName: String,
        @Field("password") password: String,
        @Field("confirm_password") confirmPassword: String
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
    @FormUrlEncoded
    suspend fun getLuckSlice(): Response<MutableList<LuckSlice>>

    @POST("luck/check")
    @FormUrlEncoded
    suspend fun checkUserLuck(): Response<Boolean>

    @POST("luck/store")
    @FormUrlEncoded
    suspend fun createLuck(@Field("coin") coin: String): Response<LuckRequest>


    //info api
    @POST("general/categories")
    @FormUrlEncoded
    suspend fun getCategory(): Response<MutableList<Category>>

    @POST("general/faqs")
    @FormUrlEncoded
    suspend fun getFaq(): Response<MutableList<Faq>>

    @POST("general/services")
    @FormUrlEncoded
    suspend fun getService(): Response<MutableList<Service>>

    @POST("general/sites")
    @FormUrlEncoded
    suspend fun getSites(): Response<MutableList<Site>>

    @POST("general/banners")
    @FormUrlEncoded
    suspend fun getBanners(): Response<MutableList<Banner>>

    @POST("general/api")
    @FormUrlEncoded
    suspend fun getApi(): Response<MutableList<Api>>

    @POST("general/agents")
    @FormUrlEncoded
    suspend fun getAgents(): Response<MutableList<Agents>>

    @POST("general/news")
    @FormUrlEncoded
    suspend fun getNews(): Response<MutableList<News>>


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
        @Field("id") id: String
    ): Response<MutableList<Transaction>>


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