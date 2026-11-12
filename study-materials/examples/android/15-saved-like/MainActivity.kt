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
        val resetButton = findViewById<Button>(R.id.resetButton)
        val prefs = getSharedPreferences("beauty_practice", MODE_PRIVATE)
        var liked = prefs.getBoolean("liked_cut", false)

        fun showStatus() {
            statusText.text = if (liked) "찜한 스타일이에요." else "아직 찜하지 않았어요"
            likeButton.text = if (liked) "찜 해제" else "찜하기"
        }
        showStatus()
        likeButton.setOnClickListener {
            liked = !liked
            prefs.edit().putBoolean("liked_cut", liked).apply()
            showStatus()
        }
        resetButton.setOnClickListener {
            prefs.edit().remove("liked_cut").apply()
            liked = false
            showStatus()
        }
    }
}
