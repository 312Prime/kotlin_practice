package kr.co.si312.listview_second_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import kr.co.si312.listview_second_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val list_item = mutableListOf<String>()
//
//        list_item.add("A")
//        list_item.add("B")
//        list_item.add("C")

        val list_item2 = mutableListOf<ListViewModel>()
        list_item2.add(ListViewModel("a","b"))
        list_item2.add(ListViewModel("c","d"))
        list_item2.add(ListViewModel("e","f"))

        val listview = findViewById<ListView>(R.id.mainlistview)

        val listviewAdapter = ListViewAdapter(list_item2)
        listview.adapter = listviewAdapter

        listview.setOnItemClickListener { adapterView, view, i, l ->

//            Toast.makeText(this,list_item[i],Toast.LENGTH_SHORT).show()
        }

    }
}