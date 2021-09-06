package kr.co.si312.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.co.si312.scrollview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener{
            binding.textView.text = "Y : ${binding.scroll1.scrollY}"
            binding.textView2.text="X : ${binding.scroll2.scrollX}"
        }
        binding.button2.setOnClickListener{
           // 지정된 위치로 애니메이션 없이 이동
           // binding.scroll1.scrollTo(0,1000)
           // binding.scroll2.scrollTo(1000,0)
            // 지정된 위치로 애니메이션과 함께 이동
           // binding.scroll1.smoothScrollTo(0,1000)
           // binding.scroll2.smoothScrollTo(1000,0)
            // 지정된 만큼 애니메이션과 함께 이동
            binding.scroll1.smoothScrollBy(0,1000)
            binding.scroll2.smoothScrollBy(1000,0)
        }

        binding.scroll1.setOnScrollChangeListener(listener1)
        binding.scroll2.setOnScrollChangeListener { view, i, i2, i3, i4 ->
            binding.textView2.text = "X : ${i3} -> ${i}"
        }
    }

    val listener1 = object :  View.OnScrollChangeListener{
        override fun onScrollChange(p0: View?, p1: Int, p2: Int, p3: Int, p4: Int) {
            when(p0?.id){
                R.id.scroll1 -> {
                    binding.textView.text = "Y : ${p4} -> ${p2}"
                }
            }
        }
    }
}