package com.example.movieapp.models.now_playing_movies

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NowPlayingMovies {
  @SerializedName("page")
  @Expose
  var page: Int? = null

  @SerializedName("results")
  @Expose
  var results: List<Result>? = null

  @SerializedName("dates")
  @Expose
  var dates: Dates? = null

  @SerializedName("total_pages")
  @Expose
  var totalPages: Int? = null

  @SerializedName("total_results")
  @Expose
  var totalResults: Int? = null

}