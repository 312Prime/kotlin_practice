package kr.co.si312.customlistview1

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kr.co.si312.customlistview1.databinding.ActivityMainBinding
import kr.co.si312.customlistview1.databinding.RowBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding1: ActivityMainBinding
    lateinit var binding2: RowBinding

    val data1 = arrayOf("문자열1", "문자열2", "문자열3", "문자열4", "문자열5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityMainBinding.inflate(layoutInflater)
        binding2 = RowBinding.inflate(layoutInflater)
        setContentView(binding1.root)
        setContentView(binding2.root)

        val adapter1 = ArrayAdapter(this, R.layout.row, R.id.rowTextView, data1)
        binding1.list1.adapter = adapter1

    }
}