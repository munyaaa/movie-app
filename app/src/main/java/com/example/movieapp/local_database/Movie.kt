package com.example.movieapp.local_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_movie_table")
data class Movie (
  @PrimaryKey
  val id: String,
  @ColumnInfo(name = "title")
  val title: String,
  @ColumnInfo(name = "release_date")
  val releaseDate: String,
  @ColumnInfo(name = "overview")
  val overview: String
)