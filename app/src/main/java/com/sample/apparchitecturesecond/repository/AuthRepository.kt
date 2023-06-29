package com.sample.apparchitecturesecond.repository

import androidx.lifecycle.MutableLiveData
import com.sample.apparchitecturesecond.model.LoginRequestModel
import com.sample.apparchitecturesecond.model.LoginResponse
import com.sample.apparchitecturesecond.model.RegisterRequestModel
import com.sample.apparchitecturesecond.model.RegisterResponseModel
import com.sample.apparchitecturesecond.network.RestInterFace
import com.sample.apparchitecturesecond.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {

    var networkInterface: RestInterFace =
        RetrofitClient.getRetrofit()!!.create(RestInterFace::class.java)

    fun performlogin(request: LoginRequestModel): MutableLiveData<LoginResponse> {
        var livedata: MutableLiveData<LoginResponse> = MutableLiveData();
        networkInterface.login(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {

                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

            }

        })
        return livedata;
    }

    fun performRegister(request: RegisterRequestModel): MutableLiveData<RegisterResponseModel> {
        var livedata: MutableLiveData<RegisterResponseModel> = MutableLiveData();
        networkInterface.register(request).enqueue(object : Callback<RegisterResponseModel> {
            override fun onResponse(
                call: Call<RegisterResponseModel>,
                response: Response<RegisterResponseModel>
            ) {
                if (response.isSuccessful) {
                    livedata.value = response.body()
                }
            }

            override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {

            }
        })
        return livedata
    }
}