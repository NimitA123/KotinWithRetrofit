package com.example.kotlin1_we

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("/comments")
    fun getPost(@Query("postId") postId:Int): Call<List<ResponseDTO>>
}