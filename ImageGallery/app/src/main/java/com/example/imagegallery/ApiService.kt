package com.example.imagegallery

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
interface ApiService {
    @GET("photos/random")
    fun getImages(
        @Header("Authorization") authorization: String = "Client-ID wnWYkrW9m9AXxv-vfLLgb8gqNjdX43sWKLtN0cWJo6E",
        @Query("count") count: Int = 10
    ): Call<List<ImageModel>>
}