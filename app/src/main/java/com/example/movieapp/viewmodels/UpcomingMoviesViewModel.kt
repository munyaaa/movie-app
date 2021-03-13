package com.example.movieapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.models.upcoming_movies.UpcomingMovies
import com.example.movieapp.repositories.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UpcomingMoviesViewModel : ViewModel() {
  private val movieRepository = MovieRepository()
  var upcomingMovies = MutableLiveData<UpcomingMovies>()

  fun getUpcomingMovies() {
    viewModelScope.launch {
      withContext(Dispatchers.Main) {
        try {
          val response =  movieRepository.getUpcomingMovies()
          upcomingMovies.postValue(response)
        } catch (throwable: Throwable) {
        }
      }
    }
  }
}