package com.example.movieapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.models.popular_movies.Result
import com.example.movieapp.views.MovieDetailsActivity

class PopularMovieAdapter(private val movies: List<Result>) :
    RecyclerView.Adapter<PopularMovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: CardView = view.findViewById(R.id.movieCard)
        val title: TextView = view.findViewById(R.id.movie_title)
        val releaseDate: TextView = view.findViewById(R.id.movie_release_date)
        val overview: TextView = view.findViewById(R.id.overview)
        val context: Context = view.context
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movie_card, viewGroup, false)

        return MovieViewHolder(
            view
        )
    }

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        viewHolder.title.text = movies[position].title
        viewHolder.releaseDate.text = movies[position].releaseDate
        viewHolder.overview.text = movies[position].overview

        viewHolder.container.setOnClickListener {
            val intent = Intent(viewHolder.context, MovieDetailsActivity::class.java)
            intent.putExtra("movieId", movies[position].id)
            viewHolder.context.startActivity(intent)
        }
    }

    override fun getItemCount() = movies.size

}

