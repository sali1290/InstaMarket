package com.e.instamarket.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.TransactionModel
import com.e.instamarket.R

class TransactionAdapter(
    private val transactionList: MutableList<TransactionModel>,
    private val context: Context
) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val typeTextView: TextView = itemView.findViewById(R.id.textView27)
        val amountTextView: TextView = itemView.findViewById(R.id.textView25)
        val statusTextView: TextView = itemView.findViewById(R.id.textView23)
        val dateTextView: TextView = itemView.findViewById(R.id.textView21)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_transasction, parent, false)
        return TransactionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.typeTextView.text = transactionList[position].type.toString()
        holder.amountTextView.text = transactionList[position].amount.toString() + "تومان "
        if (transactionList[position].status.toString() == "1") {
            holder.statusTextView.text = "موفق"
            holder.statusTextView.setTextColor(context.getColor(R.color.green))
        } else {
            holder.statusTextView.text = "ناموفق"
            holder.statusTextView.setTextColor(context.getColor(R.color.red))
        }
        holder.dateTextView.text = transactionList[position].created.toString()
    }

    override fun getItemCount(): Int = transactionList.size


}