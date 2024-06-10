package com.example.capstone_3

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

class ChoiceBaekrokFragment : Fragment() {

    private var arrayList: ArrayList<MainData>? = null
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
        item_cart = view.findViewById(R.id.item_cart)
    }

    private fun setOnClickListeners() {
        layout_1.setOnClickListener { showItemDialog("등심돈까스", R.drawable.deungsim, "4800", 360) }
        layout_2.setOnClickListener { showItemDialog("고치돈", R.drawable.gochidon, "5000", 450) }
        layout_3.setOnClickListener { showItemDialog("치킨까스", R.drawable.chicken, "4900", 430) }
        layout_4.setOnClickListener { showItemDialog("라면", R.drawable.lamen_1, "3000", 350) }
        layout_5.setOnClickListener { showItemDialog("떡만두라면", R.drawable.lamen_2, "3500", 360) }
        layout_6.setOnClickListener { showItemDialog("해장라면", R.drawable.lamen_3, "3300", 370) }
        layout_7.setOnClickListener { showItemDialog("수육국밥", R.drawable.gookbap_1, "5800", 430) }
        layout_8.setOnClickListener { showItemDialog("얼큰국밥", R.drawable.gookbap_2, "6300", 420) }

        item_cart.setOnClickListener {
            val intent = Intent(activity, Item_Cart::class.java)
            intent.putParcelableArrayListExtra("cartList", arrayList)
            startActivity(intent)
        }
    }

    open fun showItemDialog(itemName: String, itemImageId: Int, itemPrice: String, itemCalories: Int) {
        val builder = AlertDialog.Builder(requireContext())
        val message = "알레르기 정보 : ${itemPrice}Kcal\n칼로리 : ${itemCalories}원\n"
        builder.setTitle(itemName).setMessage(message)
            .setPositiveButton("장바구니 담기") { _, _ ->
                val mainData = MainData(itemImageId, itemName, itemPrice, R.drawable.item_delete_image)
                addToCart(mainData)
                Toast.makeText(requireContext(), "장바구니에 담김", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("취소") { _, _ ->
                Toast.makeText(requireContext(), "취소", Toast.LENGTH_SHORT).show()
            }
        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun addToCart(mainData: MainData) {
        if (arrayList == null) {
            arrayList = ArrayList()
        }
        arrayList!!.add(mainData)
    }

    override fun onResume() {
        super.onResume()
        if (arrayList == null) {
            arrayList = ArrayList()
        }
        val intent = activity?.intent
        if (intent != null && intent.hasExtra("cartList_return")) {
            val cartList = intent.getParcelableArrayListExtra<MainData>("cartList_return")
            if (cartList != null) {
                arrayList!!.clear()
                arrayList!!.addAll(cartList)
            }
        }
    }
}
