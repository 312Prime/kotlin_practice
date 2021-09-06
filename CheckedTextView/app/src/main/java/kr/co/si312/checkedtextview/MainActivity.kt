package kr.co.si312.checkedtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckedTextView
import kr.co.si312.checkedtextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{

            binding.textView.text = ""

            //체크박스
            if(binding.checkedTextView.isChecked == true) {
                binding.textView.append("첫 번째 체크박스가 체크되어 있습니다\n")
            }else {
                binding.textView.append("첫 번째 체크박스가 체크되어 있지 않습니다\n")
            }

            if(binding.checkedTextView2.isChecked == true) {
                binding.textView.append("두 번째 체크박스가 체크되어 있습니다\n")
            }else{
                binding.textView.append("두 번째 체크박스가 체크되어 있지 않습니다\n")
            }

            if(binding.checkedTextView3.isChecked == true) {
                binding.textView.append("세 번째 체크박스가 체크되어 있습니다\n")
            }else{
                binding.textView.append("세 번째 체크박스가 체크되어 있지 않습니다다\n")
           }

            if(binding.checkedTextView4.isChecked == true){
                binding.textView.append("첫 번째 라디오 버튼이 선택되어 있습니다\n")
            } else if(binding.checkedTextView5.isChecked == true){
                binding.textView.append("두 번째 라디오 버튼이 선택되어 있습니다\n")
            } else if(binding.checkedTextView6.isChecked == true){
                binding.textView.append("세 번째 라디오 버튼이 선택되어 있습니다\n")
            }
        }

        binding.button2.setOnClickListener{
            binding.checkedTextView.isChecked =false
            binding.checkedTextView2.isChecked = true
            binding.checkedTextView3.isChecked = true

            binding.checkedTextView4.isChecked = false
            binding.checkedTextView5.isChecked = false
            binding.checkedTextView6.isChecked = true
        }

        binding.checkedTextView.setOnClickListener(listener1)
        binding.checkedTextView2.setOnClickListener(listener1)
        binding.checkedTextView3.setOnClickListener(listener1)

        binding.checkedTextView4.setOnClickListener(listener2)
        binding.checkedTextView5.setOnClickListener(listener2)
        binding.checkedTextView6.setOnClickListener(listener2)
    }

    val listener1 = object : View.OnClickListener{
        override fun onClick(p0: View?) {

            //형변환
            val obj = p0 as CheckedTextView

            if(obj.isChecked == true){
                obj.isChecked = false
            } else {
                obj.isChecked = true
            }
        }
    }
    val listener2 = object : View.OnClickListener{
        override fun onClick(p0: View?) {
            binding.checkedTextView4.isChecked = false
            binding.checkedTextView5.isChecked = false
            binding.checkedTextView6.isChecked = false

            val obj = p0 as CheckedTextView
            obj.isChecked = true

        }
    }

}