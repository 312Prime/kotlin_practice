package kr.co.si312.autocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.co.si312.autocompletetextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val data1 = arrayOf("abcd", "abca", "abcb", "abcc", "bbaa", "bbab", "bcab", "bccb")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data1)

        binding.autoCompleteTextView.setAdapter(adapter1)

        binding.button.setOnClickListener {
            binding.textView.text = binding.autoCompleteTextView.text
        }

            //binding.autoCompleteTextView.setOnItemClickListener(listener1)
            binding.autoCompleteTextView.setOnItemClickListener { adapterView, view, i, l ->
                binding.textView2.text = "${data1[i]} 항목을 클릭했습니다"
            }
        }

        val listener1 = object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.textView2.text = "${data1[p2]} 항목을 클릭했습니다"


            }
        }
    }
