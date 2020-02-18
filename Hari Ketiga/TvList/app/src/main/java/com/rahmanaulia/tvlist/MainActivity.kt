package com.rahmanaulia.tvlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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

        initSwipeRefresh()

        Handler().postDelayed({
            getDataApi()
        }, 1200)
    }

    private fun initSwipeRefresh() {
        swipeTv.setOnRefreshListener {
            getDataApi()
            swipeTv.isRefreshing = false
        }
    }

    private fun showLoading(){
        swipeTv.isRefreshing = true
        rvTv.visibility = View.GONE
    }

    private fun hideLoading(){
        swipeTv.isRefreshing = false
        rvTv.visibility = View.VISIBLE
    }

    private fun getDataApi(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.themoviedb.org/3/discover/tv?api_key=$apiKey"

        showLoading()
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String>{response ->  
                val tvResponse = Gson().fromJson(response, TvResponse::class.java)
                hideLoading()
                if (tvResponse != null){
                    initTvAdapter(tvResponse)
                }
            }, Response.ErrorListener {error ->
                Log.e(TAG, "error volley: ${error.message}")
            })
        queue.add(stringRequest)
    }

    private fun initTvAdapter(tvResponse: TvResponse) {
        val adapter = tvResponse.results?.let {
            TvAdapter(this, it)
        }
        adapter?.notifyDataSetChanged()

        rvTv.layoutManager = LinearLayoutManager(this)
        rvTv.adapter = adapter
    }
}
