package com.example.movieapp.views

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.local_database.MovieDatabase
import com.example.movieapp.viewmodels.MovieDetailsViewModel
import com.squareup.picasso.Picasso


class MovieDetailsActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_movie_details)

    setToolbar()

    val toolbarDetailsTitle: TextView = findViewById(R.id.toolbar_details_title)
    val id = intent.extras?.get("movieId")
    val title: TextView = findViewById(R.id.movie_title)
    val releaseDate: TextView = findViewById(R.id.movie_release_date)
    val favoriteButton: ToggleButton = findViewById(R.id.favoriteButton)
    val posterImage: ImageView = findViewById(R.id.movie_image)
    val overview: TextView = findViewById(R.id.overview)

    val movieDetailsViewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)
    movieDetailsViewModel.getMovieDetails(id.toString())

    movieDetailsViewModel.movieDetails.observe(this, Observer {
      toolbarDetailsTitle.text = it.title
      title.text = it.title
      releaseDate.text = it.releaseDate
      overview.text = it.overview

      applyImageUrl(it.posterPath.toString(), posterImage)
      favoriteButtonOnClickListener(favoriteButton)
    })
  }

  private fun applyImageUrl(imageUrl: String, imageView: ImageView) {
    Picasso.get()
      .load("https://image.tmdb.org/t/p/w500/${imageUrl}")
      .error(R.drawable.ic_baseline_broken_image_24)
      .fit()
      .into(imageView)
  }

  private fun setToolbar() {
    val toolbar: Toolbar = findViewById(R.id.toolbar_details)
    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
  }

  private fun favoriteButtonOnClickListener(favoriteButton: ToggleButton) {
    favoriteButton.setOnCheckedChangeListener { _, isChecked ->
      if (isChecked) {
        Toast.makeText(this, "Unfav", Toast.LENGTH_SHORT).show()
      } else {
        Toast.makeText(this, "Fav", Toast.LENGTH_SHORT).show()
      }
    }
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
  }
}