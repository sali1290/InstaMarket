package com.e.instamarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.UserModel
import com.e.instamarket.R

class ProfileInfoAdapter(private val userModel: UserModel) :
    RecyclerView.Adapter<ProfileInfoAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_name)
        val body: TextView = itemView.findViewById(R.id.et_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.apply {
            when (position) {

                0 -> {
                    title.text = "نام"
                    body.text = userModel.firstName
                }
                1 -> {
                    title.text = "نام خانوادگی"
                    body.text = userModel.lastName
                }
                2 -> {
                    title.text = "ایمیل"
                    body.text = userModel.email
                }
                3 -> {
                    title.text = "نام کاربری"
                    body.text = userModel.userName
                }
                4 -> {
                    title.text = "شماره تلفن"
                    body.text = userModel.phone
                }
                5 -> {
                    title.text = "تاریخ تولد"
                    body.text = userModel.birthday
                }
                6 -> {
                    title.text = "تحصیلات"
                    body.text = userModel.education
                }
                7 -> {
                    title.text = "وضعیت تاهل"
                    body.text = userModel.marry
                }
                8 -> {
                    title.text = "جنسیت"
                    body.text = userModel.sex
                }

            }
        }
    }

    override fun getItemCount() = 9


}