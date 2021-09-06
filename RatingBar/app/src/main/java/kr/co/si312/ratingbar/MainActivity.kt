package kr.co.si312.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import kr.co.si312.ratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.textView.text = "Rating 1 :${binding.ratingBar.rating}\n"
            binding.textView.append("Rating 2 : ${binding.ratingBar2.rating}\n")
            binding.textView.append("Rating 3 : ${binding.ratingBar3.rating}\n")
            binding.textView.append("Rating 4: ${binding.ratingBar4.rating}\n")
        }

        binding.button2.setOnClickListener{
            binding.ratingBar.rating = 1.0f
            binding.ratingBar2.rating = 3.5f
            binding.ratingBar3.rating = 2.0f
            binding.ratingBar4.rating = 4.0f
        }
        binding.ratingBar2.setOnRatingBarChangeListener(listener1)
        binding.ratingBar3.setOnRatingBarChangeListener(listener1)
        binding.ratingBar4.setOnRatingBarChangeListener { ratingBar, fl, b ->
            binding.textView3.text= "Rating 4 : ${fl}\n"

            if(b == true){
                binding.textView3.append("사용자에 의해 설정되었습니다")
                } else {
                    binding.textView3.append("코드를 통해 설정되었습니다")
            }
        }


    }

    var listener1 = object : RatingBar.OnRatingBarChangeListener{
        override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
            when(p0?.id){
                R.id.ratingBar2 -> {
                    binding.textView.text = "Rating 2: ${p1}\n"
                    if (p2 == true){
                        binding.textView.append("사용자에 의해 설정되었습니다")
                    } else{
                        binding.textView.append("코드를 통해 설정되었습니다")
                    }
                }
                R.id.ratingBar3 -> {
                    binding.textView2.text = "Rating 3 : ${p1}\n"
                    if (p2 == true){
                        binding.textView2.append("사용자에 의해 설정되었습니다")
                    } else {
                        binding.textView2.append("코드를 통해 설정되었습니다")
                    }
                }
            }
        }
    }
}