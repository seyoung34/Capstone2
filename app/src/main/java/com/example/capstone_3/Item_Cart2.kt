package com.example.capstone_3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/** @noinspection ALL
 */
class Item_Cart2 : AppCompatActivity() {
    private var arrayList: ArrayList<MainData>? = null
    private var mainAdapter: MainAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private var move_chenge: Button? = null
    var result_2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_cart2)
        recyclerView = findViewById<View>(R.id.rv) as RecyclerView
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView!!.setLayoutManager(linearLayoutManager)
        arrayList = ArrayList()
        mainAdapter = MainAdapter(arrayList)
        recyclerView!!.setAdapter(mainAdapter)
        move_chenge = findViewById(R.id.move_baekrok)

        // SharedPreferences 초기화
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        // 다른 식당의 주문 수 가져오기
        result_2 = sharedPreferences.getInt("orderCountB", 0)
        @SuppressLint("MissingInflatedId", "LocalSuppress") val btn_pay =
            findViewById<View>(R.id.btn_pay) as Button
        btn_pay.setOnClickListener {
            val intent = Intent(this@Item_Cart2, Pay::class.java)
            result_2 += arrayList!!.size
            sharedPreferences.edit().putInt("orderCountB", result_2).apply()
            startActivity(intent)
        }
        move_chenge?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Item_Cart2, ChoiceChengeFragment::class.java)
            intent.putParcelableArrayListExtra("cartList_return", arrayList)
            startActivity(intent)
        })
    }

    override fun onResume() {

        // onResume 시, Intent로부터 장바구니 목록을 받아와서 리스트에 반영
        val intent = intent
        if (intent != null && intent.hasExtra("cartList")) {
            val cartList = intent.getParcelableArrayListExtra<MainData>("cartList")
            if (cartList != null) {
                arrayList!!.clear()
                arrayList!!.addAll(cartList)
                mainAdapter!!.notifyDataSetChanged()
            }
        }
        super.onResume()
    }

    override fun onBackPressed() {
        val intent = Intent(this@Item_Cart2, ChoiceChengeFragment::class.java)
        intent.putParcelableArrayListExtra("cartList_return", arrayList)
        super.onBackPressed()
    }
}