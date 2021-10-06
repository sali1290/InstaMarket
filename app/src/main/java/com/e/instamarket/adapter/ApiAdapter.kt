package com.e.instamarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.ApiModel
import com.e.instamarket.R

class ApiAdapter(private val apiList: MutableList<ApiModel>) :
    RecyclerView.Adapter<ApiAdapter.ApiViewHolder>() {

    inner class ApiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.api_title)
        val code: TextView = itemView.findViewById(R.id.api_code)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_api, parent, false)
        return ApiViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        holder.code.text = apiList[position].key
        holder.title.text = apiList[position].name

        }

    override fun getItemCount(): Int = apiList.size

}