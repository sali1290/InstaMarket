package com.e.data.api

import com.e.data.entity.User
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("/User")
    suspend fun getUser() : Response<User>

}