package com.example.capstone_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets -> //시스템바 고려해서 레이아웃 표시
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("testt","MainActivity에서 onCreate 로그")

        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()

        // 바텀 네비게이션 뷰 리스너 설정
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
                    true
                }
                R.id.menu_order -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, OrderFragment()).commit()
                    true
                }
                R.id.menu_cart -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, ItemCartFragment()).commit()
                    true
                }
                else -> false
            }
        }



    }

}