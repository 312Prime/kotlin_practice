package kr.co.si312.rv_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<String>()

        items.add("a")
        items.add("b")
        items.add("c")

        val rv = findViewById<RecyclerView>(R.id.rv)

        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

        rvAdapter.itemClick = object : RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext,items[position],Toast.LENGTH_SHORT).show()
            }
        }

    }
}