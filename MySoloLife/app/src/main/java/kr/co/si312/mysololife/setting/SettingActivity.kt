package kr.co.si312.mysololife.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kr.co.si312.mysololife.R
import kr.co.si312.mysololife.SplashActivity
import kr.co.si312.mysololife.auth.IntroActivity
import kr.co.si312.mysololife.auth.LoginActivity
import javax.security.auth.login.LoginException

class SettingActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        val logoutBtn = findViewById<Button>(R.id.logoutBtn)

        auth = Firebase.auth

        logoutBtn.setOnClickListener {
            auth.signOut()
            val intent = Intent(this,IntroActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}