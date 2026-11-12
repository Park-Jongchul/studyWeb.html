package com.example.beautystart

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class MainActivity : AppCompatActivity() {
    private var count = 0

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
        count = savedInstanceState?.getInt("count") ?: 0
        val statusText = findViewById<TextView>(R.id.statusText)
        val countButton = findViewById<Button>(R.id.countButton)
        statusText.text = "횟수: $count"
        Log.d("BeautyLesson", "onCreate: count=$count")
        countButton.setOnClickListener {
            count = count + 1
            statusText.text = "횟수: $count"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", count)
        super.onSaveInstanceState(outState)
    }
    override fun onDestroy() {
        Log.d("BeautyLesson", "onDestroy")
        super.onDestroy()
    }
}
