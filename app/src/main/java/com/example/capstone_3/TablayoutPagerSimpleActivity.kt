package com.example.capstone_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TablayoutPagerSimpleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tab_layout)

//        val viewPager = findViewById<ViewPager>(R.id.viewPager)
//        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
//
//        // 탭레이아웃에 탭을 추가하는 방법
//        tabLayout.addTab(tabLayout.newTab().setText("HOME"))
//        tabLayout.addTab(tabLayout.newTab().setText("ORDER"))
//        tabLayout.addTab(tabLayout.newTab().setText("ITEM CART"))
//
//        viewPager.adapter = ViewPagerAdapter(LayoutInflater.from(this), 3)
//
//        // 탭 선택에 따라 해당하는 액티비티로 이동하는 리스너 설정
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                when (tab?.position) {
//                    0 -> startActivity(Intent(this@TablayoutPagerSimpleActivity, MainActivity::class.java))
//                    1 -> startActivity(Intent(this@TablayoutPagerSimpleActivity, choice_cafeteria::class.java))
//                    2 -> startActivity(Intent(this@TablayoutPagerSimpleActivity, Item_Cart::class.java))
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {}
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {}
//        })
//
//        // 페이지 변경에 따라 탭 선택 변경
//        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }
}


class ViewPagerAdapter(
    val layoutInflater: LayoutInflater,
    val tabCount: Int
) : PagerAdapter() {
    override fun getCount(): Int {
        return tabCount
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
//        == -> 값을 비교한다
//        === -> 주소값을 비교한다
//        a = 1, b = 1 -> a==b(True), a === b (True,False)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when (position) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.activity_main, container, false)
                container.addView(view)
                return view
            }
            1 -> {
                val view = layoutInflater.inflate(R.layout.choice_cafeteria, container, false)
                container.addView(view)
                return view
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.item_cart, container, false)
                container.addView(view)
                return view
            }
        }
    }
}