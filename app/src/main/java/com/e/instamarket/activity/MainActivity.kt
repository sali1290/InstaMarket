package com.e.instamarket.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.e.instamarket.R
import com.e.instamarket.adapter.MenuItemData
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import github.hellocsl.cursorwheel.CursorWheelLayout


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.home
    }
}

