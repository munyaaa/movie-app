package com.example.movieapp.views

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.viewmodels.MovieDetailsViewModel

class MovieDetailsActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_movie_details)

    val id = intent.extras?.get("movieId")

    val title: TextView = findViewById(R.id.movie_title)
    val releaseDate: TextView = findViewById(R.id.movie_release_date)
    val favoriteButton: ToggleButton = findViewById(R.id.favoriteButton)
    val overview: TextView = findViewById(R.id.overview)

    val movieDetailsViewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)
    movieDetailsViewModel.getMovieDetails(id.toString())

    movieDetailsViewModel.movieDetails.observe(this, Observer {
      title.text = it.title
      releaseDate.text = it.releaseDate
      overview.text = it.overview

      favoriteButton.setOnCheckedChangeListener { _, isChecked ->
        if (isChecked) {
          Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show()
        } else {
          Toast.makeText(this, "Not Checked", Toast.LENGTH_SHORT).show()
        }
      }
    })
  }
}