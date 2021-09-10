package com.e.instamarket.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.ApiModel
import com.e.instamarket.R

class ApiAdapter(private val apiList: MutableList<ApiModel>, private val context: Context) :
    RecyclerView.Adapter<ApiAdapter.ApiViewHolder>() {

    inner class ApiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.api_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_api, parent, false)
        return ApiViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        val name = apiList[position].name
        val key = apiList[position].key
        holder.button.text = apiList[position].name
        holder.button.setOnClickListener {
            if (holder.button.text == name) {
                holder.button.text = key
            } else {
                holder.button.text = name
            }
        }
    }


    override fun getItemCount(): Int = apiList.size

}