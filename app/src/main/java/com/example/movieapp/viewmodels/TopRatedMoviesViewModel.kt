package com.example.movieapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.models.top_rated_movies.TopRatedMovies
import com.example.movieapp.repositories.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopRatedMoviesViewModel : ViewModel() {
  private val movieRepository = MovieRepository()
  var topRatedMovies = MutableLiveData<TopRatedMovies>()

  fun getTopRatedMovies() {
    viewModelScope.launch {
      withContext(Dispatchers.Main) {
        try {
          val response =  movieRepository.getTopRatedMovies()
          topRatedMovies.postValue(response)
        } catch (throwable: Throwable) {

        }
      }
    }
  }
}