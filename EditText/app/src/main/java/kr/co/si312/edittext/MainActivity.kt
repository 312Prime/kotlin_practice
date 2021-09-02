package kr.co.si312.edittext

import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import kr.co.si312.edittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.button1.setOnClickListener {
                binding.textView1.text = binding.editText1.text

                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.editText1.windowToken, 0)

                binding.editText1.clearFocus()
            }

        binding.editText1.addTextChangedListener(listener1)



    }
    val listener1 = object : TextWatcher{
        //문자열이 변경되기 전
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            binding.textView1.text = "before : $p0"
        }
        //문자열 변경 작업이 완료되었을 때
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            binding.textView2.text = "changed : $p0"
        }
        //변경된 문자열이 화면에 반영되었을 때
        override fun afterTextChanged(p0: Editable?) {
            binding.textView3.text = "after : $p0"
        }
        }

    }



