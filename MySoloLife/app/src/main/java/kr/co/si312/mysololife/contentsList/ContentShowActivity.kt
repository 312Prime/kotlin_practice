package kr.co.si312.mysololife.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import kr.co.si312.mysololife.R

class ContentShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_show)

        val getUrl = intent.getStringExtra("url")

        val webView : WebView = findViewById(R.id.webView)
        webView.loadUrl(getUrl.toString())
    }
}