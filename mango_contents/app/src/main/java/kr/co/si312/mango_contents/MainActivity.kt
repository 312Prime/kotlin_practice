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
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/v-RowkZv59kw",
                "https://mp-seoul-image-production-s3.mangoplate.com/270698/620857_1473924755965_33440?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "마왕족발"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/AWjEH32llwJ2",
                "https://mp-seoul-image-production-s3.mangoplate.com/415889/1853129_1609424556313_99786?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "델리봉봉"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/2WjT9Cab0I5B",
                "https://mp-seoul-image-production-s3.mangoplate.com/1937806_1619938789076035.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "아리키친"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/FfyBieJGyd",
                "https://mp-seoul-image-production-s3.mangoplate.com/106919/1955052_1620493378785_1185?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "하다코참치"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/DHj-5jwYvT6C",
                "https://mp-seoul-image-production-s3.mangoplate.com/257099_1522813696990166.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "태성추어탕"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Dm7M54U7Ja9z",
                "https://mp-seoul-image-production-s3.mangoplate.com/455721/60039_1619495740626_50345?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "군반장"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,items)
        recyclerView.adapter = rvAdapter

        recyclerView.layoutManager = GridLayoutManager(this,2)
    }
}