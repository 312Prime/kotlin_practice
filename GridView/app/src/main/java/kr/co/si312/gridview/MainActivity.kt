package kr.co.si312.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.co.si312.gridview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val data1 = arrayOf("그리드1","그리드2","그리드3","그리드4","그리드5",
                        "그리드6","그리드7","그리드8","그리드9","그리드10")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,data1)

        binding.grid1.adapter=adapter1
        //binding.grid1.setOnItemClickListener(listener1)
        binding.grid1.setOnItemClickListener { adapterView, view, i, l ->
            binding.textView.text = "${data1[i]} 번째 항목을 클릭하였습니다"
        }
    }

    val listener1 = object : AdapterView.OnItemClickListener{
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when(p0?.id){
                R.id.grid1 ->{
                    binding.textView.text= "${data1[p2]} 번째 항목을 클릭하였습니다"
                }
            }
        }
    }

}