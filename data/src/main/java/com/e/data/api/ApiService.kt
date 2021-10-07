package com.e.data.api

import com.e.data.entity.*
import com.e.data.entity.local.Ticket
import com.e.data.entity.local.User
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
    suspend fun getUser(): Response<User>

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
    suspend fun getLuckSlice(): Response<LuckSliceList>

    @POST("luck/check")
    suspend fun checkUserLuck(): Response<Boolean>

    @POST("luck/store")
    suspend fun createLuck(
        @Body coinRequest: CoinRequest
    ): Response<LuckRequest>


    //info api
    @POST("general/categories")
    suspend fun getCategory(): Response<CategoryList>

    @POST("general/faqs")
    suspend fun getFaq(): Response<FaqList>

    @POST("general/services")
    suspend fun getService(): Response<ServiceList>

    @POST("general/sites")
    suspend fun getSites(): Response<SiteList>

    @POST("general/banners")
    suspend fun getBanners(): Response<BannerList>

    @POST("general/api")
    suspend fun getApi(): Response<ApiList>

    @POST("general/agents")
    suspend fun getAgents(): Response<AgentList>

    @POST("general/news")
    suspend fun getNews(): Response<NewsList>

    @POST("general/about_us")
    suspend fun aboutUs(): Response<AboutUsResult>

    @POST("general/rules")
    suspend fun rules(): Response<AboutUsResult>

    @POST("general/contact_us")
    suspend fun contactUs(): Response<AboutUsResult>


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
    suspend fun createOrder(
        @Body orderRequestConverter: OrderRequestConverter
    ): Response<OrderRequest>

    @POST("order/get")
    suspend fun getUserOrders(@Body id: String): Response<OrderList>


    //transaction api
    @POST("transaction/create")
    suspend fun createTransaction(
        @Body createTransactionRequest: CreateTransactionRequest
    ): Response<TransactionLink>

    @POST("transaction/get")
    suspend fun getUserTransaction(
        @Body transactionRequest: TransactionRequest
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