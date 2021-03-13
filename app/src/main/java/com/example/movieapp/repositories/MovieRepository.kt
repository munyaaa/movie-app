package com.example.movieapp.repositories

import com.example.movieapp.services.ApiRequest

class MovieRepository {
  private val apiRequest = ApiRequest()
  private val apiService = apiRequest.getClient()

  suspend fun getMovieDetails(movieId: String) = apiService.getMovieDetails(movieId = movieId, apiKey = apiRequest.apiKey)

  suspend fun getNowPlayingMovies() = apiService.getNowPlayingMovies(apiKey = apiRequest.apiKey)

  suspend fun getPopularMovies() = apiService.getPopularMovies(apiKey = apiRequest.apiKey)

  suspend fun getTopRatedMovies() = apiService.getTopRatedMovies(apiKey = apiRequest.apiKey)

  suspend fun getUpcomingMovies() = apiService.getUpcomingMovies(apiKey = apiRequest.apiKey)
}