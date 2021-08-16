package com.e.data.api

import com.e.data.entity.*
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {

    @POST("/User")
    @FormUrlEncoded
    suspend fun saveUser(user: User): Response<User>

    @GET("/product")
    suspend fun getSingleProduct(): Response<Product>

    @GET("/productList")
    suspend fun getProductList(): Response<List<Product>>

    @POST("/transaction")
    @FormUrlEncoded
    suspend fun saveTransaction(transaction : Transaction): Response<Transaction>

    @GET("/transaction")
    suspend fun getTransactionList(): Response<List<Transaction>>


}