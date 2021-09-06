package com.e.instamarket.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.e.instamarket.R


class EnterAppViewPagerAdapter(fA: FragmentActivity) :
    RecyclerView.Adapter<EnterAppViewPagerAdapter.PagerViewHolder>() {

    private val fragmentActivity = fA

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_view_pager, parent, false)
        return PagerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {

        when (position) {
            0 -> {
                holder.title.text = fragmentActivity.getString(R.string.title1)
                holder.body.text = fragmentActivity.getString(R.string.body1)
            }

            1 -> {
                holder.title.text = fragmentActivity.getString(R.string.title2)
                holder.body.text = fragmentActivity.getString(R.string.body2)
            }

            2 -> {
                holder.title.text = fragmentActivity.getString(R.string.title3)
                holder.body.text = fragmentActivity.getString(R.string.body3)
            }

            3 -> {
                holder.title.text = fragmentActivity.getString(R.string.title4)
                holder.body.text = fragmentActivity.getString(R.string.body4)
            }

            else -> {
                holder.title.text = fragmentActivity.getString(R.string.title1)
                holder.body.text = fragmentActivity.getString(R.string.body1)
            }
        }


    }

    override fun getItemCount(): Int = 4

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.imageView3)
        var title: TextView = itemView.findViewById(R.id.textView8)
        var body: TextView = itemView.findViewById(R.id.textView9)


    }
}


