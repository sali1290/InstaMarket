package com.e.instamarket.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.SiteModel
import com.e.instamarket.R

class SitesAdapter(private val siteList: MutableList<SiteModel> , private val context: Context) :
    RecyclerView.Adapter<SitesAdapter.SiteViewHolder>() {

    inner class SiteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val siteName: TextView = itemView.findViewById(R.id.site_name)
        val siteSubject: TextView = itemView.findViewById(R.id.site_subject)
        val sitePrice: TextView = itemView.findViewById(R.id.site_price)
        val moreInfo: Button = itemView.findViewById(R.id.btn_more_info)
        val buySite : Button = itemView.findViewById(R.id.btn_buy_site)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiteViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_site, parent, false)
        return SiteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SiteViewHolder, position: Int) {
        holder.siteName.text = siteList[position].name
        holder.siteSubject.text = siteList[position].subject
        holder.sitePrice.text = siteList[position].price
        holder.moreInfo.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            dialog.apply {
                setMessage(siteList[position].des)
                setPositiveButton("متوجه شدم" , null)
                show()
            }
        }
    }

    override fun getItemCount() = siteList.size

}