package kr.co.si312.mysololife.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kr.co.si312.mysololife.MainActivity
import kr.co.si312.mysololife.R
import kr.co.si312.mysololife.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.joinBtn.setOnClickListener {

            var isGoToJoin = true

            val email = binding.emailArea.text.toString()
            val password1 = binding.passwordArea1.text.toString()
            val password2 = binding.passwordArea2.text.toString()

            //값이 옳은지 확인
            if (email.isEmpty()){
                Toast.makeText(this,"이메일을 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }
            if (password1.isEmpty()) {
                Toast.makeText(this, "패스워드를 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }
            if (password2.isEmpty()) {
                Toast.makeText(this, "패스워드 확인을 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }
            //비밀번호 같은지 확인
            if (!password1.equals(password2)){
                Toast.makeText(this, "패스워드를 똑같이 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }
            //비밀번호 길이 확인
            if (password1.length <6){
                Toast.makeText(this, "비밀번호는 6자리 이상이어야 합니다", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if (isGoToJoin){
                auth.createUserWithEmailAndPassword(email, password1)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this,"성공", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                } else {

                    Toast.makeText(this,"실패",Toast.LENGTH_SHORT).show()
                }
            }


            }
        }



//
    }
}