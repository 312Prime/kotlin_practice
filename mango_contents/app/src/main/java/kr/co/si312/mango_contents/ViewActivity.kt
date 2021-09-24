package kr.co.si312.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)



        val webview = findViewById<WebView>(R.id.webView)
        webview.loadUrl(intent.getStringExtra("url").toString())
    }
}