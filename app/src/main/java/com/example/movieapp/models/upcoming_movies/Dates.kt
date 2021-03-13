package com.example.movieapp.models.upcoming_movies

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Dates {
  @SerializedName("maximum")
  @Expose
  var maximum: String? = null

  @SerializedName("minimum")
  @Expose
  var minimum: String? = null

}