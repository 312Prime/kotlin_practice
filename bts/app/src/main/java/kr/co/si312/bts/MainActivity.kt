package kr.co.si312.bts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kr.co.si312.bts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //화면 클릭 알림
        val image1 = findViewById<ImageView>(R.id.Image1)
        val image2 = findViewById<ImageView>(R.id.Image2)
        val image3 = findViewById<ImageView>(R.id.Image3)
        val image4 = findViewById<ImageView>(R.id.Image4)
        val image5 = findViewById<ImageView>(R.id.Image5)
        val image6 = findViewById<ImageView>(R.id.Image6)
        val image7 = findViewById<ImageView>(R.id.Image4)


    }


}