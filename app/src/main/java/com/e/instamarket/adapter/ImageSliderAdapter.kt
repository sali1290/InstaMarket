package com.e.instamarket.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.e.instamarket.R

class ImageSliderAdapter(
    private val context: Context
) :
    RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        when (position) {

            0 -> {
                holder.imageView.scaleType = ImageView.ScaleType.FIT_XY
                Glide.with(context).load(
                    R.drawable.baner1
                ).into(holder.imageView)
            }

            1 -> {
                holder.imageView.scaleType = ImageView.ScaleType.FIT_XY
                Glide.with(context).load(
                    R.drawable.baner2
                ).into(holder.imageView)
            }

            2 -> {
                holder.imageView.scaleType = ImageView.ScaleType.FIT_XY
                Glide.with(context).load(
                    R.drawable.baner3
                ).into(holder.imageView)
            }

            3 -> {
                holder.imageView.scaleType = ImageView.ScaleType.FIT_XY
                Glide.with(context).load(
                    R.drawable.baner4
                ).into(holder.imageView)
            }

            4 -> {
                holder.imageView.scaleType = ImageView.ScaleType.FIT_XY
                Glide.with(context).load(
                    R.drawable.baner5
                ).into(holder.imageView)
            }

            5 -> {
                holder.imageView.scaleType = ImageView.ScaleType.FIT_XY
                Glide.with(context).load(
                    R.drawable.baner6
                ).into(holder.imageView)
            }


        }
    }

    override fun getItemCount(): Int = 6
}