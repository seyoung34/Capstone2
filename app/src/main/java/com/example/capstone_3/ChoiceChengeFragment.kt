package com.example.capstone_3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class ChoiceChengeFragment : Fragment() {
    var layout_1: LinearLayout? = null
    var layout_2: LinearLayout? = null
    var layout_3: LinearLayout? = null
    var item_cart: TextView? = null
    private var arrayList: ArrayList<MainData>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.choice_chenge, container, false)

        layout_1 = view.findViewById(R.id.gimchizzigae)
        layout_2 = view.findViewById(R.id.woodong)
        layout_3 = view.findViewById(R.id.yukwhue)
        item_cart = view.findViewById(R.id.item_cart)

        if (arrayList == null) {
            arrayList = ArrayList()
        }

        layout_1?.setOnClickListener { v ->
            val builder = AlertDialog.Builder(v.context)
            val string_deungsim = "ex)알레르기 정보 : 돼지고기, 밀, 대두 \n560kccal\n5500원"
            builder.setTitle("김치찌개").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.gimchizzigae, "김치찌개", "5500원", R.drawable.item_delete_image)
                addToCart(mainData)
                Toast.makeText(activity?.applicationContext, "장바구니에 담김", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("취소") { dialog, id ->
                Toast.makeText(
                    activity?.applicationContext,
                    "취소",
                    Toast.LENGTH_SHORT
                ).show()
            }
            val alertDialog = builder.create()
            alertDialog.show()
        }

        // layout_2 및 layout_3의 클릭 이벤트 핸들러 작성

        item_cart?.setOnClickListener {
            val intent = Intent(activity, Item_Cart2::class.java)
            intent.putParcelableArrayListExtra("cartList", arrayList)
            startActivity(intent)
        }

        return view
    }

    private fun addToCart(mainData: MainData) {
        if (arrayList == null) {
            arrayList = ArrayList()
        }
        arrayList!!.add(mainData)
    }
}
