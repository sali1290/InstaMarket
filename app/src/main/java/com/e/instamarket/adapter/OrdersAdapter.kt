package com.e.instamarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.e.domain.models.OrderModel
import com.e.instamarket.R

class OrdersAdapter(private val ordersList: MutableList<OrderModel>) :
    RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {

    inner class OrdersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shenase: TextView = itemView.findViewById(R.id.tv_shenase)
        val buyDate: TextView = itemView.findViewById(R.id.tv_buy_date)
        val shomarande: TextView = itemView.findViewById(R.id.tv_shomarande)
        val status: TextView = itemView.findViewById(R.id.tv_status)
        val orderPrice: TextView = itemView.findViewById(R.id.tv_order_price)
        val orderDetail: TextView = itemView.findViewById(R.id.btn_order_detail)

        val orderAddress: TextView = itemView.findViewById(R.id.tv_order_address)
        val orderShenase: TextView = itemView.findViewById(R.id.tv_order_shenase)

        val detail: CardView = itemView.findViewById(R.id.card_detail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return OrdersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        holder.apply {
            shenase.text = "شناسه: " + ordersList[position].id.toString()

            if (ordersList[position].created.toString().isEmpty()) {
                buyDate.text = "تاریخ خرید: نامشخص"
            } else {
                buyDate.text = "تاریخ خرید: " + ordersList[position].created.toString()
            }

            shomarande.text = "شروع شمارنده: " + ordersList[position].start

            if (ordersList[position].status != "pending") {
                status.text = "وضعیت: موفق"
            } else {
                status.text = "وضعیت: " + ordersList[position].status
            }

            orderPrice.text = "مبلغ: " + ordersList[position].charge

            orderDetail.setOnClickListener {
                if (holder.detail.visibility == View.GONE) {
                    holder.detail.visibility = View.VISIBLE
                } else {
                    holder.detail.visibility = View.GONE
                }

            }

            orderAddress.text = ordersList[position].link
            orderShenase.text = ordersList[position].serviceId
        }
    }

    override fun getItemCount() = ordersList.size

}