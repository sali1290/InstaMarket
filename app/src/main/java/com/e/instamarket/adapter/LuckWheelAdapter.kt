package com.e.instamarket.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.e.instamarket.R
import dagger.hilt.android.AndroidEntryPoint
import github.hellocsl.cursorwheel.CursorWheelLayout
import okhttp3.internal.notify

class LuckWheelAdapter(
    private var menuItemData: List<MenuItemData>,
    private val mContext: Context
) : CursorWheelLayout.CycleWheelAdapter {

    private var inflater = LayoutInflater.from(mContext)

    override fun getCount(): Int = menuItemData.size

    override fun getView(parent: View?, position: Int): View {
        val itemData: MenuItemData = getItem(position)
        val root: View = inflater.inflate(R.layout.item_luck, null, false)
        val textView: TextView = root.findViewById(R.id.textView29)
        textView.visibility = View.VISIBLE
        textView.text = itemData.mTitle

        if (position == 4) {
            textView.setTextColor(mContext.getColor(R.color.teal_700))
        }

        return root
    }

    override fun getItem(position: Int): MenuItemData {
        return menuItemData[position]
    }
}

data class MenuItemData(
    val mTitle: String
)