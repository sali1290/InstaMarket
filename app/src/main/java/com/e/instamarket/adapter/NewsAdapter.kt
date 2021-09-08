package com.e.instamarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.NewsModel
import com.e.instamarket.R

class NewsAdapter(private val news: MutableList<NewsModel>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView11)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.textView.text = HtmlCompat.fromHtml(news[position].description.toString() , 0)
    }

    override fun getItemCount(): Int = news.size

}