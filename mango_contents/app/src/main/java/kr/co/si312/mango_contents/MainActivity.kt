package kr.co.si312.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val items = mutableListOf<ContentsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/6eKPJ1FDuktN",
                "https://mp-seoul-image-production-s3.mangoplate.com/1918081_1616347244460074.jpg",
                "엉클스 보라카이"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/iYHC-kMDCqY4",
                "https://mp-seoul-image-production-s3.mangoplate.com/398298/1468402_1579427955935_11571",
                "마키노차야"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/6_39yDyEqLAv",
                "https://mp-seoul-image-production-s3.mangoplate.com/448036/60039_1628393992049_57801",
                "공차"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,items)
        recyclerView.adapter = rvAdapter

        recyclerView.layoutManager = GridLayoutManager(this,2)
    }
}