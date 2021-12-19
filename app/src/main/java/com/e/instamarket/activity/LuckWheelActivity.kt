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
import com.google.android.material.snackbar.Snackbar
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


    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luck_wheel)

        viewModel = ViewModelProvider(this).get(LuckViewModel::class.java)
        wheelText = findViewById(R.id.wheel_text)
        wheelButton = findViewById(R.id.btn_lucky_wheel)

        //get slices
        viewModel.setLuckWheel()
        loadData()
        observeLuckSlice()

        //check user luck
        viewModel.haveLuck()
        observeUserLuck()

    }


    private fun loadData() {
        textList.add(MenuItemData("OFF"))
        adapter = LuckWheelAdapter(textList, baseContext)
        wheelText.setAdapter(adapter)
        wheelText.isClickable = false

    }

    private fun observeLuckSlice() {
        viewModel.luckSliceList.observe({ lifecycle }, {

            when (it) {
                is Result.Success -> {
                    textList.removeFirst()
                    for (i in 0 until it.data.size) {
                        textList.add(MenuItemData(it.data[i].name.toString() + "\nتومان"))
                    }
                    textList.add(MenuItemData("پوچ"))
                    wheelText.removeViewAt(0)
                    adapter = LuckWheelAdapter(textList, baseContext)
                    wheelText.setAdapter(adapter)
                    wheelText.setOnMenuSelectedListener { parent, view, pos ->
                        if (number == 1) {
                            Snackbar.make(wheelButton, textList[pos].mTitle, Snackbar.LENGTH_LONG)
                                .show()
                            viewModel.getLuckResponse(textList[pos].mTitle.substringBefore("تومان"))
                            observeLuckResponse()
                        }
                    }

                    if (wheelButton.isClickable) {
                        wheelButton.setOnClickListener {
                            number++
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

                }

                is Result.Loading -> {
//                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                }
                is Result.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }


        })
    }

    private fun observeUserLuck() {

        viewModel.luck.observe({ lifecycle }, {
            when (it) {
                is Result.Success -> {
                    if (it.data) {
                        wheelButton.isClickable = it.data
                        Snackbar.make(
                            wheelButton,
                            "you have luck",
                            Snackbar.LENGTH_LONG
                        )
                            .show()
                    } else {
                        wheelButton.isClickable = false
                        Snackbar.make(
                            wheelButton,
                            "امروز شانسی ندارید!! بعدا امتحان کنید",
                            Snackbar.LENGTH_LONG
                        )
                            .show()
                    }

                }

                is Result.Loading -> {
                }

                is Result.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    private fun observeLuckResponse() {
        viewModel.luckResponse.observe({ lifecycle }, {

            when (it) {
                is Result.Success -> {
                    Snackbar.make(wheelButton, it.data.message!! + "", Snackbar.LENGTH_SHORT)
                        .show()
                }

                is Result.Loading -> {
                }

                is Result.Error -> {
                }
            }
        })
    }


}