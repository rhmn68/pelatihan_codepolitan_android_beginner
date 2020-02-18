package com.rahmanaulia.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        getData()
    }

    private fun getData() {
        if (intent != null){
            val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
            if (movie != null){
                tvTitleMovieDetail.text = movie.title
                tvReleaseDateMovieDetail.text = movie.releaseDate
                tvRatingMovieDetail.text = movie.voteAverage.toString()
                tvOverviewMovieDetail.text = movie.overview

                val baseUrlImage = "https://image.tmdb.org/t/p/w154"
                val urlImage = baseUrlImage + movie.posterPath

                Glide.with(this).load(urlImage).into(ivMovieDetail)
            }
        }
    }
}
