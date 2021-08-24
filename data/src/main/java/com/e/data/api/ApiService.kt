package com.e.data.api

import com.e.data.entity.*
import com.e.data.entity.local.Order
import com.e.data.entity.local.Ticket
import com.e.data.entity.local.User
import com.e.data.entity.remote.*
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiService {

    //login api
    @POST("/auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<Token>

    @POST("/auth/register")
    suspend fun register(
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: User,
        @Field("user_name") userName: String,
        @Field("password") password: String
    ): Response<Token>

    @POST("/auth/user")
    suspend fun getUser(
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: User,
        @Field("user_name") userName: String,
        @Field("password") password: String
    ): Response<String>

    @POST("/auth/logout")
    suspend fun logout(
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: User,
        @Field("user_name") userName: String,
        @Field("password") password: String
    ): Response<String>


    //luck api
    @POST("/luck/slices")
    suspend fun getLuckSlice(): Response<MutableList<LuckSlice>>

    @POST("/luck/check")
    suspend fun checkUserLuck(): Response<Boolean>

    @POST("/luck/store")
    suspend fun createLuck(@Field("coin") coin: String): Response<LuckRequest>


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
    suspend fun updateUser(
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String
    ): Response<Boolean>

    @POST("/user/checkVerify")
    suspend fun checkUserIsVerify(): Response<Boolean>

    @POST("/user/authenticate")
    suspend fun verifyUser(@Field("code") code: String): Response<Token>

    @POST("/user/sendVerifyCode")
    suspend fun sendVerify(): Response<Token>


    //order api
    @POST("/product")
    suspend fun createOrder(
        @Field("category_id") categoryId: String,
        @Field("service_id") serviceId: String,
        @Field("quantity") quantity: String,
        @Field("link") link: String
    ): Response<OrderRequest>

    @POST("/productList")
    suspend fun getUserOrders(@Field("id") id: String): Response<MutableList<Order>>


    //transaction api
    @POST("/transaction/create")
    suspend fun createTransaction(
        @Field("amount") amount: String,
        @Field("type") type: String
    ): Response<String>

    @POST("/transaction/get")
    suspend fun getUserTransaction(
        @Field("id") id: String
    ): Response<MutableList<Transaction>>


    //ticket api
    @POST("/ticket/create")
    suspend fun createTicket(
        @Field("subject") subject: String,
        @Field("order_id") order_id: String,
        @Field("type") type: String,
        @Field("description") description: String
    ): Response<TicketRequest>

    @POST("/ticket/get")
    suspend fun getTicket(@Field("id") id: String): Response<MutableList<Ticket>>


}