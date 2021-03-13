package com.example.movieapp.repositories

import android.content.Context
import com.example.movieapp.local_database.Movie
import com.example.movieapp.local_database.MovieDatabase

class LocalMovieRepository(context: Context) {
    val movieDatabase: MovieDatabase? = MovieDatabase.getInstance(context)

    suspend fun getAllMovie() = movieDatabase?.getMovieDao()?.getAll()
    suspend fun addMovie(movie: Movie) = movieDatabase?.getMovieDao()?.insert(movie)
}