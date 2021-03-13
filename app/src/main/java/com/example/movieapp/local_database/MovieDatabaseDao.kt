package com.example.movieapp.local_database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDatabaseDao {
  @Query("SELECT * FROM favorite_movie_table")
  fun getAll(): List<Movie>

  @Insert
  fun insert(movie: Movie)

  @Query("SELECT * FROM favorite_movie_table WHERE id = :id")
  fun getById(id: String): Movie

  @Delete
  fun delete(movie: Movie)
}
