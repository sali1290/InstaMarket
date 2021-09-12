package com.e.instamarket.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.domain.models.LuckSliceModel
import com.e.instamarket.R
import com.e.instamarket.adapter.LuckWheelAdapter
import com.e.instamarket.adapter.MenuItemData
import com.e.instamarket.viewmodel.luck.LuckViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import github.hellocsl.cursorwheel.CursorWheelLayout
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

@AndroidEntryPoint
class LuckWheelActivity : AppCompatActivity() {

    private lateinit var viewModel: LuckViewModel
    private var textList: MutableList<MenuItemData> = ArrayList()
    private lateinit var wheelText: CursorWheelLayout
    private lateinit var adapter: LuckWheelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luck_wheel)


        viewModel = ViewModelProvider(this).get(LuckViewModel::class.java)
        viewModel.setLuckWheel()
        initViews()
        loadData()
        observe()


    }


    private fun loadData() {
        textList.add(MenuItemData("OFF"))
        adapter = LuckWheelAdapter(textList, baseContext)
        wheelText.setAdapter(adapter)

    }


    private fun initViews() {
        wheelText = findViewById(R.id.wheel_text)
    }

    private fun observe() {
        viewModel.luckSliceList.observe({ lifecycle }, {

            when (it) {
                is Result.Success -> {
                    textList.remove(MenuItemData("OFF"))
                    for (i in 0 until it.data.size) {
                        textList.add(MenuItemData(it.data[i].name.toString() + "تومان" ))
                    }
                    adapter = LuckWheelAdapter(textList, baseContext)
                    wheelText.setAdapter(adapter)
                }

                is Result.Loading -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                }
                is Result.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }


            }


        })
    }

}