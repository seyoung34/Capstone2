package com.example.capstone_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChoiceBaekrokFragment : Fragment() {

    private lateinit var myFunc: myfunc
    private lateinit var layout_1: LinearLayout
    private lateinit var layout_2: LinearLayout
    private lateinit var layout_3: LinearLayout
    private lateinit var layout_4: LinearLayout
    private lateinit var layout_5: LinearLayout
    private lateinit var layout_6: LinearLayout
    private lateinit var layout_7: LinearLayout
    private lateinit var layout_8: LinearLayout
    private lateinit var item_cart: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.choice_baekrok, container, false)
        initializeViews(view)
        setOnClickListeners()
        return view
    }

    private fun initializeViews(view: View) {
        layout_1 = view.findViewById(R.id.deungsim)
        layout_2 = view.findViewById(R.id.gochidon)
        layout_3 = view.findViewById(R.id.chicken)
        layout_4 = view.findViewById(R.id.lamen_1)
        layout_5 = view.findViewById(R.id.lamen_2)
        layout_6 = view.findViewById(R.id.lamen_3)
        layout_7 = view.findViewById(R.id.gookbap_1)
        layout_8 = view.findViewById(R.id.gookbap_2)
        item_cart = view.findViewById(R.id.baekrok_item_cart)
        myFunc = myfunc(requireContext())
    }

    private fun setOnClickListeners() {
        layout_1.setOnClickListener { myFunc.showItemDialog("등심돈까스", R.drawable.deungsim, "4800", 360) }
        layout_2.setOnClickListener { myFunc.showItemDialog("고치돈", R.drawable.gochidon, "5000", 450) }
        layout_3.setOnClickListener { myFunc.showItemDialog("치킨까스", R.drawable.chicken, "4900", 430) }
        layout_4.setOnClickListener { myFunc.showItemDialog("라면", R.drawable.lamen_1, "3000", 350) }
        layout_5.setOnClickListener { myFunc.showItemDialog("떡만두라면", R.drawable.lamen_2, "3500", 360) }
        layout_6.setOnClickListener { myFunc.showItemDialog("해장라면", R.drawable.lamen_3, "3300", 370) }
        layout_7.setOnClickListener { myFunc.showItemDialog("수육국밥", R.drawable.gookbap_1, "5800", 430) }
        layout_8.setOnClickListener { myFunc.showItemDialog("얼큰국밥", R.drawable.gookbap_2, "6300", 420) }

//        item_cart.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.container, ItemCartFragment())
//                .addToBackStack(null)
//                .commit()
//        }
//        Log.d("testt", "클릭리스너 완료")
    }
}
