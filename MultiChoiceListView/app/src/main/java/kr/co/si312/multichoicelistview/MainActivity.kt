package kr.co.si312.multichoicelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kr.co.si312.multichoicelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val data1 = arrayOf("항목1","항목2","항목3","항목4","항목5","항목6","항목7","항목8")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,data1)
        binding.list1.adapter = adapter1
        binding.list1.choiceMode=ListView.CHOICE_MODE_MULTIPLE

        binding.list1.setItemChecked(0,true)
        binding.list1.setItemChecked(2,true)
        binding.list1.setItemChecked(4,true)

        binding.button.setOnClickListener {
            binding.textView.text = ""

            //현재 체크 상태에 관련된 객체를 가져온다.
            val boolArray = binding.list1.checkedItemPositions

//            binding.textView.text = "개수 : ${boolArray.size()}"
            for (idx in 0 until boolArray.size()){
//                binding.textView.append("${boolArray.keyAt(idx)}")
                val key = boolArray.keyAt(idx)

                //해당 항목이 체크되어 있는지 확인한다.
                if (boolArray[key] == true){
                    binding.textView.append("${data1[key]}")
                }
            }
        }
    }
}