package com.rahmanaulia.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val apiKey = "697ee77c6354b2be7fab6d7614d7c3d9"
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataApi()
    }

    private fun getDataApi() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.themoviedb.org/3/discover/movie?api_key=$apiKey"

        showLoading()
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String>{ response ->
                val movieResponse = Gson().fromJson(response, MovieResponse::class.java)

                hideLoading()
                if (movieResponse != null){
                    initMovieAdapter(movieResponse)
                }
            }, Response.ErrorListener { error ->
                Log.e(TAG, "error volley: ${error.message}")
            })
        queue.add(stringRequest)
    }

    private fun showLoading() {
        pbMovie.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        pbMovie.visibility = View.GONE
    }

    private fun initMovieAdapter(movieResponse: MovieResponse) {
        val adapter = movieResponse.results?.let {
            MovieAdapter(this, it)
        }
        adapter?.notifyDataSetChanged()
        rvMovie.layoutManager = LinearLayoutManager(this)
        rvMovie.adapter = adapter
    }
}
