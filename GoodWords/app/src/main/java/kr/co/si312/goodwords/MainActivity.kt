package kr.co.si312.goodwords

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.si312.goodwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sentenceList = mutableListOf<String>()

        sentenceList.add("삶이 있는 한 희망은 있다.")
        sentenceList.add("하루에 3시간을 걸으면 7년 후에 지구를 한바퀴 돌 수 있다.")
        sentenceList.add("신은 용기있는자를 결코 버리지 않는다.")
        sentenceList.add("피할수 없으면 즐겨라.")
        sentenceList.add("절대 어제를 후회하지 마라. 인생은 오늘의 나 안에 있고 내일은 스스로 만드는 것이다.")
        sentenceList.add("자신감 있는 표정을 지으면 자신감이 생긴다.")
        sentenceList.add(" 꿈을 계속 간직하고 있으면 반드시 실현할 때가 온다.")
        sentenceList.add("진짜 문제는 사람들의 마음이다. 그것은 절대로 물리학이나 윤리학의 문제가 아니다.")


        binding.ShowSentenceBtn.setOnClickListener {

            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
        }
        binding.SentenceArea.setText(sentenceList.random())

    }
}