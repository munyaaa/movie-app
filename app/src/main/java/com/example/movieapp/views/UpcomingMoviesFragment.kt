package com.example.movieapp.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.adapters.UpcomingMovieAdapter
import com.example.movieapp.viewmodels.UpcomingMoviesViewModel

class UpcomingMoviesFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val v: View = inflater.inflate(R.layout.movies_fragment, container, false);
    val c  = activity;

    val upcomingMoviesViewModel = ViewModelProvider(this).get(UpcomingMoviesViewModel::class.java)
    upcomingMoviesViewModel.getUpcomingMovies()

    upcomingMoviesViewModel.upcomingMovies.observe(viewLifecycleOwner, Observer {
      val recyclerView: RecyclerView = v.findViewById(R.id.recyclerView)
      val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(c)
      recyclerView.layoutManager = layoutManager

      val movieAdapter = UpcomingMovieAdapter(it.results!!)
      recyclerView.adapter = movieAdapter
      Log.d("Movie", it.results?.get(0)?.title.toString())
    })

    return v
  }
}