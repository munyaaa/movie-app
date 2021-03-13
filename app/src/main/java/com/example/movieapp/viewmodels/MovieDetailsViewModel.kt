package com.example.movieapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.models.movie_details.MovieDetails
import com.example.movieapp.repositories.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailsViewModel() : ViewModel() {
  private val movieRepository = MovieRepository()

  var movieDetails = MutableLiveData<MovieDetails>()

  fun getMovieDetails(movieId: String) {
    viewModelScope.launch {
      withContext(Dispatchers.Main) {
        try {
          val response =  movieRepository.getMovieDetails(movieId)
          movieDetails.postValue(response)
        } catch (throwable: Throwable) {
        }
      }
    }
  }
}