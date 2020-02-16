package com.rahmanaulia.tvlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_tv.view.*

class TvAdapter(private val context: Context, private val listTv: List<ResultsItem>): RecyclerView.Adapter<TvAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_tv, parent, false))
    }

    override fun getItemCount(): Int {
        return listTv.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tv = listTv[position]
        holder.itemView.tvTitleTv.text = tv.name
        holder.itemView.tvDescTv.text = tv.overview

        val baseUrlImage = "https://image.tmdb.org/t/p/w300"
        val urlImage = baseUrlImage + tv.backdropPath

        Glide.with(holder.itemView).load(urlImage).into(holder.itemView.ivTv)

        val rating = tv.voteAverage?.div(2)
        if (rating != null){
            holder.itemView.ratingTv.rating = rating.toFloat()
        }

        holder.itemView.tvRating.text = rating.toString()

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "name: ${tv.name}", Toast.LENGTH_SHORT).show()
        }
    }
}