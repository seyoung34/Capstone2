package com.example.capstone_3

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    private var orderCountA = 0
    private var orderCountB = 0
    private var orderCountC = 0
    private var textViewA: TextView? = null
    private var textViewB: TextView? = null
    private var textViewC: TextView? = null
    private var btn_pay: Button? = null
    private var btn_reset: Button? = null
    private var Left: Button? = null
    private var today_menu_text: TextView? = null
    private var today_manu: ImageView? = null
    private var menu_name: TextView? = null
    private var Right: Button? = null
    private var today_num = 0
    private var today_num1 = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home, container, false)

        textViewA = view.findViewById(R.id.textViewA)
        textViewB = view.findViewById(R.id.textViewB)
        textViewC = view.findViewById(R.id.textViewC)
        btn_pay = view.findViewById(R.id.btn_pay)
        btn_reset = view.findViewById(R.id.btn_reset)
        Left = view.findViewById(R.id.Left)
        today_menu_text = view.findViewById(R.id.today_menu_text)
        today_manu = view.findViewById(R.id.today_menu)
        Right = view.findViewById(R.id.Right)
        menu_name = view.findViewById(R.id.menu_name)

        // SharedPreferences 초기화
        val sharedPreferences = activity?.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        orderCountA = sharedPreferences?.getInt("orderCountA", 0) ?: 0
        orderCountB = sharedPreferences?.getInt("orderCountB", 0) ?: 0
        orderCountC = sharedPreferences?.getInt("orderCountC", 0) ?: 0
        textViewA?.text = "백록관 주문 대기 수: $orderCountA"
        textViewB?.text = "천지관 주문 대기 수: $orderCountB"
        textViewC?.text = "두리관 주문 대기 수: $orderCountC"

        btn_pay?.setOnClickListener {
            val intent = Intent(activity, choice_cafeteria::class.java)
            intent.putExtra("orderCountA", orderCountA)
            intent.putExtra("orderCountB", orderCountB)
            intent.putExtra("orderCountC", orderCountC)
            startActivity(intent)
        }
        btn_reset?.setOnClickListener {
            orderCountA = 0
            orderCountB = 0
            orderCountC = 0
            updateOrderCounts()
        }
        Left?.setOnClickListener {
            today_num1 += 2
            updateTodayMenu()
        }
        Right?.setOnClickListener {
            today_num1 += 1
            updateTodayMenu()
        }

        return view
    }

    private fun updateOrderCounts() {
        textViewA?.text = "백록관 주문 대기 수: $orderCountA"
        textViewB?.text = "천지관 주문 대기 수: $orderCountB"
        textViewC?.text = "두리관 주문 대기 수: $orderCountC"
        val sharedPreferences = activity?.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putInt("orderCountA", orderCountA)
        editor?.putInt("orderCountB", orderCountB)
        editor?.putInt("orderCountC", orderCountC)
        editor?.apply()
    }

    private fun updateTodayMenu() {
        today_num = today_num1 % 3
        when (today_num) {
            0 -> {
                today_menu_text?.text = "백록 한라산"
                today_manu?.setImageResource(R.drawable.kimchi_rice)
                menu_name?.text = "김치볶음밥"
            }
            1 -> {
                today_menu_text?.text = "천지 백두산"
                today_manu?.setImageResource(R.drawable.bulgogi)
                menu_name?.text = "불고기"
            }
            2 -> {
                today_menu_text?.text = "크누정식"
                today_manu?.setImageResource(R.drawable.bibimbap)
                menu_name?.text = "비빔밥"
            }
        }
    }
}
