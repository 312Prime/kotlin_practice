package kr.co.si312.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.co.si312.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 어댑터를 생성한다. 접혔을 때의 모습을 구성할 Layout을 설정한다
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
        //펼쳐졌을 때의 모습을 구성하기 위한 layout을 지정한다.
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter1

        binding.button.setOnClickListener {
            binding.textView.text = "선택한 항목 ${data1[binding.spinner.selectedItemPosition]}"
        }

        binding.spinner.onItemSelectedListener = listener1

    }

    val listener1 = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
            when(parent?.id){
                R.id.spinner -> {
                    binding.textView.text = "${data1[position]} 번째 항목이 선택되었습니다"
                }
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {

        }


}
}