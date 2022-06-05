package io.moiro.vision.shared.services.client

import io.moiro.vision.shared.services.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    fun getApiService(): ApiService {
        val builder = Retrofit.Builder()
            .baseUrl("https://vision-moiro.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(ApiService::class.java)
    }
}