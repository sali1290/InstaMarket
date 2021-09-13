package com.e.instamarket.activity

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.e.domain.Result
import com.e.instamarket.R
import com.e.instamarket.adapter.LuckWheelAdapter
import com.e.instamarket.adapter.MenuItemData
import com.e.instamarket.viewmodel.luck.LuckViewModel
import dagger.hilt.android.AndroidEntryPoint
import github.hellocsl.cursorwheel.CursorWheelLayout
import kotlin.random.Random

@AndroidEntryPoint
class LuckWheelActivity : AppCompatActivity() {

    private lateinit var viewModel: LuckViewModel
    private var textList: MutableList<MenuItemData> = ArrayList()
    private lateinit var wheelText: CursorWheelLayout
    private lateinit var wheelButton: Button
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
        wheelText.isClickable = false

    }


    private fun initViews() {
        wheelText = findViewById(R.id.wheel_text)
        wheelButton = findViewById(R.id.btn_lucky_wheel)
    }

    private fun observe() {
        viewModel.luckSliceList.observe({ lifecycle }, {

            when (it) {
                is Result.Success -> {
                    textList.removeFirst()
                    for (i in 0 until it.data.size) {
                        textList.add(MenuItemData(it.data[i].name.toString() + "تومان"))
                    }
                    textList.add(MenuItemData("پوچ"))
                    wheelText.removeViewAt(0)
                    adapter = LuckWheelAdapter(textList, baseContext)
                    wheelText.setAdapter(adapter)
                    wheelText.setOnMenuSelectedListener { parent, view, pos ->
                        Toast.makeText(this, textList[pos].mTitle, Toast.LENGTH_SHORT)
                            .show()
                    }

                    wheelButton.setOnClickListener {
                        var index: Int = Random.nextInt(textList.size)
                        wheelText.startAnimation(
                            AnimationUtils.loadAnimation(
                                this,
                                R.anim.rotate_anim
                            )
                        )
                        while (index == textList.size - 1) {
                            index = Random.nextInt(textList.size)
                        }
                        wheelText.setSelection(index)
                    }

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