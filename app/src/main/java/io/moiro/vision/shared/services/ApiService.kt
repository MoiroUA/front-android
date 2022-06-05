package io.moiro.vision.shared.services

import io.moiro.vision.shared.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("user/registration")
    fun regUser(@Body reg: Registration): Call<RegResponse>

    @POST("user/login")
    fun loginUser(@Body log: Login): Call<LoginResponse>

    @GET("user/profile")
    fun getUser(@Header("Authorization") authToken: String): Call<User>
}