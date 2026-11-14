package com.sonora.app

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)
        textView.text = "Bienvenue sur Sonora 🎵"
        textView.textSize = 24f
        textView.setPadding(50, 200, 50, 50)
        setContentView(textView)
    }
}
