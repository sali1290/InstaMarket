package com.e.instamarket.adapter

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.AgentsModel
import com.e.instamarket.R

class AgentAdapter(private val agentList: MutableList<AgentsModel>, private val context: Context) :
    RecyclerView.Adapter<AgentAdapter.AgentViewHolder>() {

    inner class AgentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textView30)
        val textViewPrice: TextView = itemView.findViewById(R.id.textView32)
        val textViewDate: TextView = itemView.findViewById(R.id.textView33)
        val descButton: TextView = itemView.findViewById(R.id.button4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_agent, parent, false)
        return AgentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        holder.textViewName.append(agentList[position].name)
        holder.textViewPrice.append(agentList[position].price)
        holder.textViewDate.append(agentList[position].day)

        holder.descButton.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            dialog.setPositiveButton("Ok", null)
            dialog.setMessage(agentList[position].des)
            dialog.show()
        }
    }

    override fun getItemCount(): Int = agentList.size

}