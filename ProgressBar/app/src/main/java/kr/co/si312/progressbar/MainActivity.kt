package kr.co.si312.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.si312.progressbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.textView.text = "현재 값 ${binding.progressBar4.progress}"
        }
        binding.button2.setOnClickListener{
            binding.progressBar4.progress = 140
        }
        binding.button3.setOnClickListener{
            binding.progressBar4.incrementProgressBy(10)
        }

        binding.button4.setOnClickListener{
            binding.progressBar4.incrementProgressBy(-10)

        }
    }
}