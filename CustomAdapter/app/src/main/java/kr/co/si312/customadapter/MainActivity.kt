package kr.co.si312.customadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kr.co.si312.customadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val data1 = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list1.adapter = adapter1
    }


    val adapter1 = object :BaseAdapter(){
        //항목의 개수를 반환한다.
        override fun getCount(): Int {
            return data1.size
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        //항목 하나를 구성하기 위해 호출되는 메서드
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            //재사용 가능한 View를 변수에 담는다.
            var rowView =p1
            if(rowView == null){
                rowView = layoutInflater.inflate(R.layout.row,null)
            }
            //항목 뷰에 내부 배치 되어있는 뷰들의 주소값을 가져온다
            //val rowTextView : TextView = findViewById(R.id.rowTextView)
            val text1 = rowView?.findViewById<TextView>(R.id.rowTextView)
            val btn1 = rowView?.findViewById<Button>(R.id.rowButton1)
            val btn2 = rowView?.findViewById<Button>(R.id.rowButton2)

            text1?.text = data1[p0]

            btn1?.tag = p0
            btn2?.tag = p0


            btn1?.setOnClickListener{
                binding.textView.text = "첫 번째 버튼을 눌렀습니다 : ${it.tag}"
            }
            btn2?.setOnClickListener{
                binding.textView.text = "두 번째 버튼을 눌렀습니다 : ${it.tag}"
            }


            return rowView!!
        }
    }
}