package com.e.data.api

import com.e.data.entity.User
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {

    @POST("/User")
    @FormUrlEncoded
    suspend fun saveUser() : Response<User>

}