package kr.co.si312.textinputlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import kr.co.si312.textinputlayout.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            binding.textView1.text = binding.textInputLayout1.editText?.text

            binding.textInputLayout1.editText?.clearFocus()

            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(
                binding.textInputLayout1.editText?.windowToken,
                0)

        }

        binding.textInputLayout1.editText?.addTextChangedListener(listener1)

    }
    val listener1 = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if(s != null){
                if(s.length > 10){
                    binding.textInputLayout1.error = "10글자 이하로 입력해주세요"
                } else {
                    binding.textInputLayout1.error = null
                }
            }
        }

        override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }
}