package com.e.instamarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.BlogModel
import com.e.instamarket.R

class BlogAdapter(private val blogList: MutableList<BlogModel>) :
    RecyclerView.Adapter<BlogAdapter.BlogViewModel>() {

    inner class BlogViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val blogItem: CardView = itemView.findViewById(R.id.btn_blog_item)
        val title: TextView = itemView.findViewById(R.id.tv_blog_title)
        val body: TextView = itemView.findViewById(R.id.tv_blog_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewModel {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_blog, parent, false)
        return BlogViewModel(itemView)
    }

    override fun onBindViewHolder(holder: BlogViewModel, position: Int) {
        holder.title.text = blogList[position].title
        holder.body.text = blogList[position].text

        holder.blogItem.setOnClickListener {
            if (holder.body.visibility == View.GONE) {
                holder.body.visibility = View.VISIBLE
            } else {
                holder.body.visibility = View.GONE
            }
        }

    }

    override fun getItemCount() = blogList.size

}