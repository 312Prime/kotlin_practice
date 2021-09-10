package kr.co.si312.mysummer

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kr.co.si312.mysummer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //toast
        val image1 = findViewById<ImageView>(R.id.imageView1)
        val image2 = findViewById<ImageView>(R.id.imageView2)
        val image3 = findViewById<ImageView>(R.id.imageView3)
        val image4 = findViewById<ImageView>(R.id.imageView4)
        val image5 = findViewById<ImageView>(R.id.imageView5)
        val image6 = findViewById<ImageView>(R.id.imageView6)
        val image7 = findViewById<ImageView>(R.id.imageView7)
        val image8 = findViewById<ImageView>(R.id.imageView8)
        val image9 = findViewById<ImageView>(R.id.imageView9)
        val image10 = findViewById<ImageView>(R.id.imageView10)
        val image11 = findViewById<ImageView>(R.id.imageView11)
        val image12 = findViewById<ImageView>(R.id.imageView12)
        val image13 = findViewById<ImageView>(R.id.imageView13)
        val image14 = findViewById<ImageView>(R.id.imageView14)
        val image15 = findViewById<ImageView>(R.id.imageView15)

        image1.setOnClickListener {
            //intent
            Toast.makeText(this,"1번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer1Actvity ::class.java)
            startActivity(intent)
        }
        image2.setOnClickListener {
            //intent
            Toast.makeText(this,"2번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer2Actvity ::class.java)
            startActivity(intent)
        }
        image3.setOnClickListener {
            //intent
            Toast.makeText(this,"3번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer3Actvity ::class.java)
            startActivity(intent)
        }
        image4.setOnClickListener {
            //intent
            Toast.makeText(this,"4번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer4Actvity ::class.java)
            startActivity(intent)
        }
        image5.setOnClickListener {
            //intent
            Toast.makeText(this,"5번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer5Actvity ::class.java)
            startActivity(intent)
        }
        image6.setOnClickListener {
            //intent
            Toast.makeText(this,"6번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer6Actvity ::class.java)
            startActivity(intent)
        }
        image7.setOnClickListener {
            //intent
            Toast.makeText(this,"7번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer7Actvity ::class.java)
            startActivity(intent)
        }
        image8.setOnClickListener {
            //intent
            Toast.makeText(this,"8번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer8Actvity ::class.java)
            startActivity(intent)
        }
        image9.setOnClickListener {
            //intent
            Toast.makeText(this,"9번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer9Actvity ::class.java)
            startActivity(intent)
        }
        image10.setOnClickListener {
            //intent
            Toast.makeText(this,"10번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer10Actvity ::class.java)
            startActivity(intent)
        }
        image11.setOnClickListener {
            //intent
            Toast.makeText(this,"11번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer11Actvity ::class.java)
            startActivity(intent)
        }
        image12.setOnClickListener {
            //intent
            Toast.makeText(this,"12번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer12Actvity ::class.java)
            startActivity(intent)
        }
        image13.setOnClickListener {
            //intent
            Toast.makeText(this,"13번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer13Actvity ::class.java)
            startActivity(intent)
        }
        image14.setOnClickListener {
            //intent
            Toast.makeText(this,"14번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer14Actvity ::class.java)
            startActivity(intent)
        }
        image15.setOnClickListener {
            //intent
            Toast.makeText(this,"15번 클릭 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, mysummer15Actvity ::class.java)
            startActivity(intent)
        }







    }
}