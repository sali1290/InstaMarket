package com.e.instamarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.FaqModel
import com.e.instamarket.R

class FaqAdapter(private val faqList: MutableList<FaqModel>) :
    RecyclerView.Adapter<FaqAdapter.FaqViewHolder>() {

    inner class FaqViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val btnQuestion: Button = itemView.findViewById(R.id.btn_question)
        val tvAnswer: TextView = itemView.findViewById(R.id.tv_answer)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_faq, parent, false)
        return FaqViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        holder.btnQuestion.text = faqList[position].question
        holder.btnQuestion.setOnClickListener {
            if (holder.tvAnswer.visibility == View.GONE) {
                holder.tvAnswer.text = faqList[position].answer
                holder.tvAnswer.visibility = View.VISIBLE
            } else {
                holder.tvAnswer.visibility = View.GONE
            }
        }


    }

    override fun getItemCount() = faqList.size


}