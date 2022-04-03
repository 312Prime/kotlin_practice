package kr.co.si312.sogating.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kr.co.si312.sogating.MainActivity
import kr.co.si312.sogating.R

class LoginActivity : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val email = findViewById<TextInputEditText>(R.id.emailArea)
            val pwd = findViewById<TextInputEditText>(R.id.passwordArea)


        auth.signInWithEmailAndPassword(email.text.toString(),pwd.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful){
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,"실패",Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}