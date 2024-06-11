package com.example.capstone_3

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class myfunc(private val context: Context) {

    fun showItemDialog(itemName: String, itemImageId: Int, itemPrice: String, itemCalories: Int) {
        val builder = AlertDialog.Builder(context)
        val message = "알레르기 정보 : \n 가격 :${itemPrice}원 \n칼로리 : ${itemCalories}Kcal\n"
        builder.setTitle(itemName).setMessage(message)
            .setPositiveButton("장바구니 담기") { _, _ ->
                val mainData = MainData(itemImageId, itemName, itemPrice, R.drawable.item_delete_image)
                addToCart(mainData)
                Toast.makeText(context, "장바구니에 담김", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("취소") { _, _ ->
                Toast.makeText(context, "취소", Toast.LENGTH_SHORT).show()
            }
        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun addToCart(mainData: MainData) {
        MainActivity.arrayList.add(mainData)
    }
}
