package com.example.movieapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.adapters.NowPlayingMovieAdapter
import com.example.movieapp.viewmodels.NowPlayingMoviesViewModel

class NowPlayingMoviesFragment: Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val v: View = inflater.inflate(R.layout.movies_fragment, container, false);
    val c  = activity;

    val nowPlayingViewModel = ViewModelProvider(this).get(NowPlayingMoviesViewModel::class.java)
    nowPlayingViewModel.getNowPlayingMovies()

    nowPlayingViewModel.nowPlayingMovies.observe(viewLifecycleOwner, Observer {
      val recyclerView: RecyclerView = v.findViewById(R.id.recyclerView)
      val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(c)
      recyclerView.layoutManager = layoutManager

      val movieAdapter = NowPlayingMovieAdapter(it.results!!)
      recyclerView.adapter = movieAdapter
    })

    return v
  }
}