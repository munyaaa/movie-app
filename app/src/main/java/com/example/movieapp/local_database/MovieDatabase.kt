package com.example.movieapp.local_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
  abstract fun getMovieDao(): MovieDatabaseDao?

  fun cleanUp() {
    movieDb = null
  }

  companion object {
    private var movieDb: MovieDatabase? = null
    fun getInstance(context: Context): MovieDatabase? {
      if (movieDb == null) {
        movieDb = buildDatabaseInstance(context)
      }
      return movieDb
    }

    private fun buildDatabaseInstance(context: Context): MovieDatabase {
      return Room.databaseBuilder(
        context,
        MovieDatabase::class.java,
        "favorite_movie_database"
      )
        .allowMainThreadQueries().build()
    }
  }
}