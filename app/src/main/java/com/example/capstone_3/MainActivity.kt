package com.example.capstone_3

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        var arrayList: ArrayList<MainData> = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("testt", "MainActivity에서 onCreate 로그")

        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()

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
                    val itemCartFragment = ItemCartFragment()
                    val bundle = Bundle()
                    bundle.putParcelableArrayList("cartList", arrayList)
                    itemCartFragment.arguments = bundle
                    supportFragmentManager.beginTransaction().replace(R.id.container, itemCartFragment).commit()
                    true
                }
                else -> false
            }
        }
    }
}
