package com.rahmanaulia.movielist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val context: Context,
                   private val movies: List<Movie>)
    :RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
       return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        holder.itemView.tvTitleMovie.text = movie.title
        holder.itemView.tvDescMovie.text = movie.overview

        val baseUrlImage = "https://image.tmdb.org/t/p/w780"
        val urlImage = baseUrlImage + movie.backdropPath

        Glide.with(context).load(urlImage).into(holder.itemView.ivMovie)

        val rating = movie.voteAverage?.div(2)
        if (rating != null){
            holder.itemView.ratingMovie.rating = rating.toFloat()
        }

        holder.itemView.tvRatingMovie.text = rating.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie)
            context.startActivity(intent)
        }
    }
}