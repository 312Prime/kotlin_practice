package kr.co.si312.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kr.co.si312.seekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.textView.text="SeekBar 1 : ${binding.seekBar.progress}"
            binding.textView2.text="SeekBar 2 : ${binding.seekBar2.progress}"
        }

        binding.button2.setOnClickListener{
            binding.seekBar.progress = 3
            binding.seekBar2.progress = 8
        }

        binding.button3.setOnClickListener{
            binding.seekBar.incrementProgressBy(1)
            binding.seekBar2.incrementProgressBy(1)
        }
        binding.button4.setOnClickListener{
            binding.seekBar.incrementProgressBy(-1)
            binding.seekBar2.incrementProgressBy(-1)
        }
        binding.seekBar.setOnSeekBarChangeListener(listener1)
        binding.seekBar2.setOnSeekBarChangeListener(listener1)
    }

    val listener1 =object : SeekBar.OnSeekBarChangeListener{
        // ProgressBar의 값이 변경되었을 때
        override fun onProgressChanged(seekbar: SeekBar?, p1: Int, p2: Boolean) {
        when(seekbar?.id){
            R.id.seekBar -> {
                binding.textView.text = "첫 번째 SeekBar가 ${p1}로 설정되었습니다\n"
        }
            R.id.seekBar2 -> {
                binding.textView.text = "두 번째 SeekBar가 ${p1}로 설정되었습니다\n"
            }
        }
            if(p2 == true){
                binding.textView.append("사용자에 의해 설정되었습니다")
            } else {
                binding.textView.append("코드를 통해 설정되었습니다")
            }
        }
        //사용자가 터치 했을 때
        override fun onStartTrackingTouch(p0: SeekBar?) {
            when(p0?.id){
                R.id.seekBar ->{
                    binding.textView2.text = "첫 번째 SeekBar 사용자 터치 시작"
                }
                R.id.seekBar2 ->{
                    binding.textView2.text = "두 번째 SeekBar 사용자 터치 시작"
                }
            }
        }
        //사용자가 터치를 끝냈을 때
        override fun onStopTrackingTouch(p0: SeekBar?) {
        when(p0?.id){
            R.id.seekBar ->{
            binding.textView2.text = "첫 번째 SeekBar 사용자 터치 종료"
        }
            R.id.seekBar2 ->{
                binding.textView2.text = "두 번째 SeekBar 사용자 터치 종료"

            }
        }
        }
    }
}