package com.example.capstone_3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChoiceChengeFragment : Fragment() {

    private lateinit var myFunc: myfunc
    private lateinit var layout_1: LinearLayout
    private lateinit var layout_2: LinearLayout
    private lateinit var layout_3: LinearLayout
    private lateinit var item_cart: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.choice_chenge, container, false)
        initializeViews(view)
        setOnClickListeners()
        return view
    }

    private fun initializeViews(view: View) {
        layout_1 = view.findViewById<LinearLayout>(R.id.gimchizzigae)
        layout_2 = view.findViewById<LinearLayout>(R.id.woodong)
        layout_3 = view.findViewById<LinearLayout>(R.id.yukwhue)
        item_cart = view.findViewById<TextView>(R.id.chenge_item_cart)
        myFunc = myfunc(requireContext())
    }

    private fun setOnClickListeners() {
        layout_1.setOnClickListener { myFunc.showItemDialog("김치찌개", R.drawable.gimchizzigae, "5500", 600) }
        layout_2.setOnClickListener { myFunc.showItemDialog("우동", R.drawable.woodong, "4000", 600) }
        layout_3.setOnClickListener { myFunc.showItemDialog("육회비빔밥", R.drawable.yukwhue, "6000", 600) }

//        item_cart.setOnClickListener {
//            val intent = Intent(activity, Item_Cart::class.java)
//            intent.putParcelableArrayListExtra("cartList", arrayList)
//            startActivity(intent)
//        }
    }

}
