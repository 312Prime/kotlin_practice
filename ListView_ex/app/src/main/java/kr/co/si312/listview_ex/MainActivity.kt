package kr.co.si312.listview_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kr.co.si312.listview_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list_item = mutableListOf<ListViewModel >()

        list_item.add(ListViewModel("a","b"))
        list_item.add(ListViewModel("c","d"))
        list_item.add(ListViewModel("e","f"))

        val listview = findViewById<ListView>(R.id.mainListview)

        val listadapter = ListViewAdapter(list_item)
        listview.adapter = listadapter
    }
}