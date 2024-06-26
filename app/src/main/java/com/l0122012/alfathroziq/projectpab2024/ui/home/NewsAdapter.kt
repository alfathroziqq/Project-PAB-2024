package com.l0122012.alfathroziq.projectpab2024.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.projectpab2024.R

class NewsAdapter(private val newsList: List<News>, private val onClick: (News) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.news_image)
        val titleView: TextView = itemView.findViewById(R.id.news_title)

        fun bind(newsItem: News) {
            imageView.setImageResource(newsItem.imageResId)
            titleView.text = newsItem.title
            itemView.setOnClickListener { onClick(newsItem) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
