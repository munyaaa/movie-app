package com.example.movieapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.models.popular_movies.PopularMovies
import com.example.movieapp.repositories.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularMoviesViewModel : ViewModel() {
  private val movieRepository = MovieRepository()
  var popularMovies = MutableLiveData<PopularMovies>()

  fun getPopularMovies() {
    viewModelScope.launch {
      withContext(Dispatchers.Main) {
        try {
          val response =  movieRepository.getPopularMovies()
          popularMovies.postValue(response)
        } catch (throwable: Throwable) {

        }
      }
    }
  }
}