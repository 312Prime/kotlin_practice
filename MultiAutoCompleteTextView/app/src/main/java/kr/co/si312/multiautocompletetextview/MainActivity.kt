package kr.co.si312.multiautocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import kr.co.si312.multiautocompletetextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val data = arrayOf("abcd", "abab","abca", "abcc", "bbab", "bbac","bbcc")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter1 = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,data)

        //구분자
        binding.multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        binding.multiAutoCompleteTextView.setAdapter(adapter1)

        binding.button.setOnClickListener{
            val strArray = binding.multiAutoCompleteTextView.text.split(",")

            binding.textView.text=""

            for(str1 in strArray){
                if(str1.trim() != ""){
                    binding.textView.append("${str1.trim()}\n")
                }
            }
        }

        binding.multiAutoCompleteTextView.setOnItemClickListener { adapterView, view, i, l ->
            binding.textView2.text = "${data[i]} 항목을 선택하였습니다"
        }
    }
}