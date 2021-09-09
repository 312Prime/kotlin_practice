package kr.co.si312.singlechoicelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kr.co.si312.singlechoicelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var data1 = arrayOf("항목1","항목2","항목3","항목4",
                         "항목5","항목6","항목7","항목8")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,data1)
        binding.list1.adapter = adapter1
        binding.list1.choiceMode=ListView.CHOICE_MODE_SINGLE
        binding.list1.setItemChecked(2,true)

        binding.button.setOnClickListener{
            binding.textView.text = "${data1[binding.list1.checkedItemPosition]} 항목이 선택되어 있습니다"
        }
    }
}