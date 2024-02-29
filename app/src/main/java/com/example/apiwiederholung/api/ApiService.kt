package com.example.apiwiederholung.api

import com.example.apiwiederholung.api.model.Quote
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl("https://api.quotable.io/")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()


interface ApiService{

    //Always returns a list, but contains only one element by default
    @GET("quotes/random")
    suspend fun getRandomQuote() : List<Quote>


}

object api{
    val service: ApiService by lazy { retrofit.create(ApiService::class.java) }
}

