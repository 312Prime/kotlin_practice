package kr.co.si312.sogating.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_intro.*
import kr.co.si312.sogating.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val loginBtn : Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener{

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        joinBtn.setOnClickListener {
            val intent = Intent(this,JoinActivity::class.java)
            startActivity(intent)
        }
    }
}