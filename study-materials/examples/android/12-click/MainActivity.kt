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
        val statusText = findViewById<TextView>(R.id.statusText)
        val likeButton = findViewById<Button>(R.id.likeButton)
        var liked = false

        likeButton.setOnClickListener {
            liked = !liked
            if (liked) {
                statusText.text = "찜한 스타일이에요."
                likeButton.text = "찜 해제"
            } else {
                statusText.text = "아직 찜하지 않았어요"
                likeButton.text = "찜하기"
            }
        }
    }
}
