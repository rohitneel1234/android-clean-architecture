package com.rohitneel.androidcleanarchitecture.data.network

import com.rohitneel.androidcleanarchitecture.data.model.PixabayDTO
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://pixabay.com/"
interface ApiService {

    @GET("api/")
    suspend fun getSearchImage(
        @Query("key") key: String,
        @Query("q") query: String
    ): PixabayDTO
}