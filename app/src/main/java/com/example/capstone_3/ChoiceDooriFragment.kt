package com.example.capstone_3


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
class ChoiceDooriFragment : Fragment() {

    private lateinit var myFunc: myfunc
    private lateinit var layout_1: LinearLayout
    private lateinit var layout_2: LinearLayout
    private lateinit var layout_3: LinearLayout
    private lateinit var item_cart: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.choice_doori, container, false)
        initializeViews(view)
        setOnClickListeners()
        return view
    }

    private fun initializeViews(view: View) {
        layout_1 = view.findViewById(R.id.hambak)
        layout_2 = view.findViewById(R.id.kalgooksu)
        layout_3 = view.findViewById(R.id.boodae)
        item_cart = view.findViewById<TextView>(R.id.doori_item_cart)
        myFunc = myfunc(requireContext())
    }

    private fun setOnClickListeners() {
        layout_1.setOnClickListener { myFunc.showItemDialog("함박스테이크", R.drawable.hambak, "6000", 600) }
        layout_2.setOnClickListener { myFunc.showItemDialog("칼국수", R.drawable.kalgooksu, "4000", 550) }
        layout_3.setOnClickListener { myFunc.showItemDialog("부대찌개", R.drawable.boodae, "5500", 650) }

//        item_cart.setOnClickListener {
//            val intent = Intent(activity, Item_Cart::class.java)
//            intent.putParcelableArrayListExtra("cartList", arrayList)
//            startActivity(intent)
//        }
    }

}
