package kr.co.si312.aswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioGroup
import kr.co.si312.aswitch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.switch1.isChecked == true) {
                binding.textView.text = "On 상태입니다"
            } else {
                binding.textView.text = "Off 상태입니다"
            }
        }
        binding.button2.setOnClickListener{
            binding.switch1.isChecked = true
        }
        binding.button3.setOnClickListener{
            binding.switch1.isChecked = false
        }
        binding.switch1.setOnCheckedChangeListener(listener1)
        binding.switch2.setOnCheckedChangeListener { compoundButton, b ->
            if(b == true){
                binding.textView2.text = "두 번째 스위치가 On 상태가 되었습니다"
            } else {
                binding.textView2.text = "두 번째 스위치가 Off 상태가 되었습니다"
            }
        }
    }

    val listener1 = object : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            when(p0?.id){
                R.id.switch1 -> {
                    if (p1 == true){
                        binding.textView.text = "첫 번째 스위치가 On 상태가 되었습니다"
                    } else {
                        binding.textView.text = "첫 번째 스위치가 Off 상태가 되었습니다"
                    }
                }
            }
        }
    }
}