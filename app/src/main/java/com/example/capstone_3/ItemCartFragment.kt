package com.example.capstone_3

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemCartFragment : Fragment() {

    private var arrayList: ArrayList<MainData>? = null
    private var mainAdapter: MainAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var move_baekrok: Button? = null
    private var btn_pay: Button? = null
    private var result_1 = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_cart, container, false)
        recyclerView = view.findViewById(R.id.rv)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        arrayList = ArrayList()
        mainAdapter = MainAdapter(arrayList)
        recyclerView?.adapter = mainAdapter
        move_baekrok = view.findViewById(R.id.move_baekrok)
        btn_pay = view.findViewById(R.id.btn_pay)

        // SharedPreferences 초기화
        val sharedPreferences = activity?.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        // 다른 식당의 주문 수 가져오기
        result_1 = sharedPreferences?.getInt("orderCountA", 0) ?: 0

        btn_pay?.setOnClickListener {
            val intent = Intent(activity, Pay::class.java)
            result_1 += arrayList!!.size
            sharedPreferences?.edit()?.putInt("orderCountA", result_1)?.apply()
            startActivity(intent)
        }

        move_baekrok?.setOnClickListener {
            val intent = Intent(activity, ChoiceBaekrokFragment::class.java)
            intent.putParcelableArrayListExtra("cartList_return", arrayList)
            startActivity(intent)
        }

        return view
    }

    override fun onResume() {
        super.onResume()

        // onResume 시, Intent로부터 장바구니 목록을 받아와서 리스트에 반영
        val intent = activity?.intent
        if (intent != null && intent.hasExtra("cartList")) {
            val cartList = intent.getParcelableArrayListExtra<MainData>("cartList")
            if (cartList != null) {
                arrayList!!.clear()
                arrayList!!.addAll(cartList)
                mainAdapter!!.notifyDataSetChanged()
            }
        }
    }
}
