package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit internal var baseLayout : LinearLayout
    lateinit internal var button1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="배경색 바꾸기"

        baseLayout = findViewById<LinearLayout>(R.id.baseLayout)
        button1 = findViewById<Button>(R.id.button1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1, menu)
        return true
    }
}
