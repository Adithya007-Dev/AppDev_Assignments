package com.example.imagegallery

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val UNSPLASH_API_BASE_URL = "https://api.unsplash.com/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(UNSPLASH_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
