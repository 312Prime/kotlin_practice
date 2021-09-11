package kr.co.si312.twice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.si312.twice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn1 = binding.imageView2
        btn1.setOnClickListener {
            val intent = Intent(this,ImageInsideActivity::class.java)
            intent.putExtra("data","1")
            startActivity(intent)
        }
        val btn2 = binding.imageView3
        btn2.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data","2")
            startActivity(intent)
        }
        val btn3 = binding.imageView4
        btn3.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data","3")
            startActivity(intent)
        }
        val btn4 = binding.imageView5
        btn4.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data","4")
            startActivity(intent)
        }
        val btn5 = binding.imageView6
        btn5.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data","5")
            startActivity(intent)
        }
        val btn6 = binding.imageView7
        btn6.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data","6")
            startActivity(intent)
        }
        val btn7 = binding.imageView8
        btn7.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data","7")
            startActivity(intent)
        }
        val btn8 = binding.imageView9
        btn8.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data","8")
            startActivity(intent)
        }
        val btn9 = binding.imageView10
        btn9.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data","9")
            startActivity(intent)
        }
    }
}