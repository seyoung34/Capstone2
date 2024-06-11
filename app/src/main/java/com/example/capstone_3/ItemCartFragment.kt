package com.example.capstone_3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemCartFragment : Fragment() {

    private var arrayList: ArrayList<MainData>? = null
    private var mainAdapter: MainAdapter? = null
    private var recyclerView: RecyclerView? = null
//    private var back_button: Button? = null
    private var btn_pay: Button? = null
    var result_1 = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_cart, container, false)
        recyclerView = view.findViewById(R.id.rv)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        arrayList = arguments?.getParcelableArrayList("cartList")
        mainAdapter = MainAdapter(arrayList!!)
        recyclerView?.adapter = mainAdapter

        // SharedPreferences 초기화
//        val sharedPreferences = getSharedPreferences("MyPrefs", AppCompatActivity.MODE_PRIVATE)
//        // 다른 식당의 주문 수 가져오기
//        result_1 = sharedPreferences.getInt("orderCountA", 0)
//        btn_pay.setOnClickListener {
//            val intent = Intent(activity, Pay::class.java)
//            result_1 += arrayList!!.size
//            sharedPreferences.edit().putInt("orderCountA", result_1).apply()
//            startActivity(intent)
//        }

        btn_pay = view.findViewById(R.id.btn_pay)
        btn_pay?.setOnClickListener {
            val intent = Intent(activity, Pay::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        arrayList?.let {
            mainAdapter?.notifyDataSetChanged()
        }
    }
}
