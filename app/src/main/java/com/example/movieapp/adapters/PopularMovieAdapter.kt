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

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: CardView = view.findViewById(R.id.movieCard)
        val title: TextView = view.findViewById(R.id.movie_title)
        val releaseDate: TextView = view.findViewById(R.id.movie_release_date)
        val context: Context = view.context
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovieViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movie_card, viewGroup, false)

        return MovieViewHolder(
            view
        )
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.title.text = movies[position].title
        viewHolder.releaseDate.text = movies[position].releaseDate

        viewHolder.container.setOnClickListener {
            val intent = Intent(viewHolder.context, MovieDetailsActivity::class.java)
            intent.putExtra("movieId", movies[position].id)
            viewHolder.context.startActivity(intent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = movies.size

}

