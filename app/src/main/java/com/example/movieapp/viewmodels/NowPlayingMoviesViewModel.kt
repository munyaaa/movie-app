package com.example.movieapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.models.now_playing_movies.NowPlayingMovies
import com.example.movieapp.repositories.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NowPlayingMoviesViewModel : ViewModel() {
  private val movieRepository = MovieRepository()
  var nowPlayingMovies = MutableLiveData<NowPlayingMovies>()

  fun getNowPlayingMovies() {
    viewModelScope.launch {
      withContext(Dispatchers.Main) {
        try {
          val response =  movieRepository.getNowPlayingMovies()
          nowPlayingMovies.postValue(response)
        } catch (throwable: Throwable) {

        }
      }
    }
  }
}