package com.example.beautystart

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 상태 표시줄과 본문이 겹치지 않게 하는 준비 코드예요.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById<View>(R.id.mainRoot)) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val priceInput = findViewById<EditText>(R.id.priceInput)
        val addButton = findViewById<Button>(R.id.addButton)
        val resultText = findViewById<TextView>(R.id.resultText)
        val styleList = findViewById<LinearLayout>(R.id.styleList)

        addButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val price = priceInput.text.toString().trim().toIntOrNull()
            if (name.isBlank()) {
                nameInput.error = "스타일 이름을 적어 주세요."
                return@setOnClickListener
            }
            if (price == null || price < 0) {
                priceInput.error = "0 이상의 정수를 적어 주세요."
                return@setOnClickListener
            }
            val item = TextView(this)
            item.text = "$name · ${price}원"
            item.textSize = 20f
            styleList.addView(item)
            resultText.text = "화면에만 추가했어요. 다시 실행하면 사라져요."
            nameInput.text.clear()
            priceInput.text.clear()
        }
    }
}
