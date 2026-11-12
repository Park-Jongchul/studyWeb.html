package com.example.beautystart

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    data class Style(val id: Int, val name: String, val category: String, val price: Int)
    private val styles = listOf(
        Style(1, "내추럴 커트", "헤어", 30000),
        Style(2, "웨이브 펌", "헤어", 70000),
        Style(3, "데일리 메이크업", "메이크업", 50000)
    )

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
        val searchInput = findViewById<EditText>(R.id.searchInput)
        val searchButton = findViewById<Button>(R.id.searchButton)
        val onlyLiked = findViewById<CheckBox>(R.id.onlyLiked)
        val statusText = findViewById<TextView>(R.id.statusText)
        val styleList = findViewById<LinearLayout>(R.id.styleList)
        val detailText = findViewById<TextView>(R.id.detailText)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val prefs = getSharedPreferences("beauty_lookbook", MODE_PRIVATE)

        // 읽어 온 Set을 직접 바꾸지 않고, 수정 가능한 복사본을 만들어요.
        val likedIds = (prefs.getStringSet("liked_ids", emptySet()) ?: emptySet()).toMutableSet()
        if (savedInstanceState != null) {
            searchInput.setText(savedInstanceState.getString("query", ""))
            onlyLiked.isChecked = savedInstanceState.getBoolean("only_liked", false)
            detailText.text = savedInstanceState.getString("detail", "스타일을 선택하세요.")
        }

        fun renderStyles() {
            styleList.removeAllViews()
            val query = searchInput.text.toString().trim()
            val visible = styles.filter { style ->
                style.name.contains(query, ignoreCase = true) &&
                    (!onlyLiked.isChecked || style.id.toString() in likedIds)
            }
            statusText.text = if (visible.isEmpty()) {
                "조건에 맞는 스타일이 없어요."
            } else {
                "${visible.size}개 표시 · 찜 ${likedIds.size}개"
            }
            for (style in visible) {
                val card = LinearLayout(this)
                card.orientation = LinearLayout.VERTICAL
                val space = (12 * resources.displayMetrics.density).toInt()
                card.setPadding(space, space, space, space)

                val title = TextView(this)
                title.text = "${style.name} · ${style.category} · ${style.price}원"
                title.textSize = 20f

                val detailButton = Button(this)
                detailButton.text = "${style.name} 자세히 보기"
                detailButton.setOnClickListener {
                    detailText.text = "선택: ${style.name} / ${style.category} / ${style.price}원"
                }
                val likeButton = Button(this)
                val key = style.id.toString()
                likeButton.text = if (key in likedIds) "${style.name} 찜 해제" else "${style.name} 찜하기"
                likeButton.setOnClickListener {
                    if (key in likedIds) likedIds.remove(key) else likedIds.add(key)
                    prefs.edit().putStringSet("liked_ids", likedIds.toSet()).apply()
                    renderStyles()
                    // 목록 재생성 뒤 키보드·보조기기 탐색을 위한 고정 위치예요.
                    searchButton.requestFocus()
                }
                card.addView(title)
                card.addView(detailButton)
                card.addView(likeButton)
                styleList.addView(card)
            }
        }
        searchButton.setOnClickListener { renderStyles() }
        onlyLiked.setOnCheckedChangeListener { _, _ -> renderStyles() }
        resetButton.setOnClickListener {
            likedIds.clear()
            prefs.edit().remove("liked_ids").apply()
            searchInput.setText("")
            onlyLiked.isChecked = false
            detailText.text = "스타일의 자세히 보기를 눌러 주세요."
            renderStyles()
        }
        renderStyles()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("query", findViewById<EditText>(R.id.searchInput).text.toString())
        outState.putBoolean("only_liked", findViewById<CheckBox>(R.id.onlyLiked).isChecked)
        outState.putString("detail", findViewById<TextView>(R.id.detailText).text.toString())
        super.onSaveInstanceState(outState)
    }
}
