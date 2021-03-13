package com.example.movieapp.services

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRequest {
  private val baseUrl : String = "https://api.themoviedb.org/"
  val apiKey : String = "6536e7bb4e7e4639be81983775a3e75e"

  fun getClient() : IApiService {
    val retrofit: Retrofit = Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
      .build()

    return retrofit.create(IApiService::class.java)
  }

}