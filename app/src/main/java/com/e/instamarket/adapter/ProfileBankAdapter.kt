package com.e.instamarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.UserModel
import com.e.instamarket.R

class ProfileBankAdapter(private val userModel: UserModel) :
    RecyclerView.Adapter<ProfileBankAdapter.ProfileBankViewHolder>() {

    inner class ProfileBankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_name)
        val body: TextView = itemView.findViewById(R.id.et_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileBankViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return ProfileBankViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileBankViewHolder, position: Int) {
        holder.apply {
            when (position) {
                0 -> {
                    title.text = "شماره کارت"
                    body.text = userModel.cardNumber
                }
                1 -> {
                    title.text = "شماره شبا"
                    body.text = userModel.shNumber
                }
                2 -> {
                    title.text = "نام بانک"
                    body.text = userModel.bankName
                }
            }
        }
    }

    override fun getItemCount() = 4

}