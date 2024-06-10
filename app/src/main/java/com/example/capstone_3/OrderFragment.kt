package com.example.capstone_3

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class OrderFragment : Fragment() {

    private var btn_1: Button? = null
    private var btn_2: Button? = null
    private var btn_3: Button? = null
    var result_1 = 0
    var result_2 = 0
    var result_3 = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.choice_cafeteria, container, false)

        btn_1 = view.findViewById(R.id.btn_1)
        btn_2 = view.findViewById(R.id.btn_2)
        btn_3 = view.findViewById(R.id.btn_3)

        // SharedPreferences 초기화
        val sharedPreferences = activity?.getSharedPreferences("MyPrefs", MODE_PRIVATE)

        // 다른 식당의 주문 수 가져오기
        result_1 = sharedPreferences?.getInt("orderCountA", 0) ?: 0
        result_2 = sharedPreferences?.getInt("orderCountB", 0) ?: 0
        result_3 = sharedPreferences?.getInt("orderCountC", 0) ?: 0


        btn_1?.setOnClickListener {
            // ChoiceBaekrokFragment로 이동
            val fragment = ChoiceBaekrokFragment() // 이동할 Fragment 인스턴스 생성
            val transaction = requireActivity().supportFragmentManager.beginTransaction() // FragmentTransaction 시작
            transaction.replace(R.id.container, fragment) // 이동할 Fragment를 지정
            transaction.addToBackStack(null) // 이전 Fragment를 스택에 추가하여 Back 버튼으로 돌아갈 수 있도록 함
            transaction.commit() // 트랜잭션 실행
        }

        btn_2?.setOnClickListener {
            // ChoiceChengeFragment로 이동
            val fragment = ChoiceChengeFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btn_3?.setOnClickListener {
            // ChoiceDooriFragment로 이동
            val fragment = ChoiceDooriFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


        return view
    }
}
