package com.example.mybooksny.data

import com.example.mybooksny.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTService {
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "sclAvKOKZh01AezeIYpEeRS6VPABDgPR",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}