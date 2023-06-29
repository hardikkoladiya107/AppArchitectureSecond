package com.sample.apparchitecturesecond.network

import com.sample.apparchitecturesecond.model.LoginRequestModel
import com.sample.apparchitecturesecond.model.LoginResponse
import com.sample.apparchitecturesecond.model.RegisterRequestModel
import com.sample.apparchitecturesecond.model.RegisterResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RestInterFace  {

    @POST("Service=login")
    fun login(@Body model :LoginRequestModel):Call<LoginResponse>;

    @POST("Service=userRegister")
    fun register(@Body model: RegisterRequestModel):Call<RegisterResponseModel>;



}