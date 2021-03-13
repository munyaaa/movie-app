package com.example.movieapp.services

import com.example.movieapp.models.movie_details.MovieDetails
import com.example.movieapp.models.now_playing_movies.NowPlayingMovies
import com.example.movieapp.models.popular_movies.PopularMovies
import com.example.movieapp.models.top_rated_movies.TopRatedMovies
import com.example.movieapp.models.upcoming_movies.UpcomingMovies
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {
  @GET("/3/movie/{movie_id}")
  suspend fun getMovieDetails(@Path("movie_id") movieId: String, @Query("api_key") apiKey: String): MovieDetails

  @GET("/3/movie/now_playing")
  suspend fun getNowPlayingMovies(@Query("api_key") apiKey: String): NowPlayingMovies

  @GET("/3/movie/popular")
  suspend fun getPopularMovies(@Query("api_key") apiKey: String): PopularMovies

  @GET("/3/movie/top_rated")
  suspend fun getTopRatedMovies(@Query("api_key") apiKey: String): TopRatedMovies

  @GET("/3/movie/upcoming")
  suspend fun getUpcomingMovies(@Query("api_key") apiKey: String): UpcomingMovies
}