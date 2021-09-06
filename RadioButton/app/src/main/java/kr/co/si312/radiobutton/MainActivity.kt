package kr.co.si312.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioGroup
import kr.co.si312.radiobutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.radioButton3.isChecked = true
            binding.radioButton6.isChecked = true
        }
        binding.button2.setOnClickListener {
            when (binding.radioGroup1.checkedRadioButtonId) {
                R.id.radioButton -> {
                    binding.textView.text = "라디오 1-1이 체크되어 있습니다"
                }
                R.id.radioButton2 -> {
                    binding.textView.text = "라디오 1-2가 체크되어 있습니다"
                }
                R.id.radioButton3 -> {
                    binding.textView.text = "라디오 1-3이 체크되어 있습니다"
                }
            }
            when (binding.radioGroup2.checkedRadioButtonId) {
                R.id.radioButton4 -> {
                    binding.textView2.text = "라디오 2-1이 체크되어 있습니다"
                }
                R.id.radioButton5 -> {
                    binding.textView2.text = "라디오 2-2가 체크되어 있습니다"
                }
                R.id.radioButton6 -> {
                    binding.textView2.text = "라디오 2-3이 체크되어 있습니다"
                }
            }
        }

        binding.radioGroup1.setOnCheckedChangeListener(listener1)
        binding.radioGroup2.setOnCheckedChangeListener { group, checkId ->
            when(checkId){
                R.id.radioButton4 -> {
                    binding.textView2.text = "라디오 2-1이 체크되었습니다"
                }
                R.id.radioButton5 -> {
                    binding.textView2.text = "라디오 2-2가 체크되었습니다"
                }
                R.id.radioButton6 -> {
                    binding.textView2.text = "라디오 2-3이 체크되었습니다"
                }
            }
        }
    }

    val listener1 = object : RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
            when(p0?.id){
                R.id.radioGroup1 ->{
                    when(p1){
                        R.id.radioButton -> {
                            binding.textView.text = "라디오 1-1이 체크되었습니다"
                        }
                        R.id.radioButton2 -> {
                            binding.textView.text = "라디오 1-2가 체크되었습니다"
                        }
                        R.id.radioButton3 -> {
                            binding.textView.text = "라디오 1-3이 체크되었습니다"
                        }
                    }
                }
            }
        }

    }
}

