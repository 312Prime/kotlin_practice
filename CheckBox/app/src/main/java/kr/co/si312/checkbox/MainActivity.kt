package kr.co.si312.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kr.co.si312.checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.textView.text = ""

            if (binding.checkBox.isChecked == true) {
                binding.textView.append("첫 번째 체크박스가 체크되어 있습니다\n")
            } else {
                binding.textView.append("첫 번째 체크박스는 해제되어 있습니다\n")
            }

            if (binding.checkBox2.isChecked == true) {
                binding.textView.append("두 번째 체크박스가 체크되어 있습니다\n")
            }else {
                    binding.textView.append("두 번째 체크박스는 해제되어 있습니다\n")
            }
            if (binding.checkBox3.isChecked == true) {
                binding.textView.append("세 번째 체크박스가 체크되어 있습니다\n")
            }else {
                binding.textView.append("세 번째 체크박스는 해제되어 있습니다\n")
            }
        }
        binding.button2.setOnClickListener {
            binding.checkBox2.isChecked = true
            binding.checkBox.isChecked = true
            binding.checkBox3.isChecked = true
        }
        binding.button3.setOnClickListener {
            binding.checkBox2.isChecked = false
            binding.checkBox.isChecked = false
            binding.checkBox3.isChecked = false
        }
        binding.button4.setOnClickListener {
            binding.checkBox.toggle()
            binding.checkBox2.toggle()
            binding.checkBox3.toggle()
        }
        binding.checkBox.setOnCheckedChangeListener(listener1)
        binding.checkBox2.setOnCheckedChangeListener(listener1)
        binding.checkBox3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked == true){
                binding.textView.text = "세 번째 체크박스가 체크되었습니다"
            } else {
                binding.textView.text = "세 번재 체크박스가 해제되었습니다"
            }
        }
    }

    val listener1 = object : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when(buttonView?.id){
                R.id.checkBox -> {
                    if(isChecked == true){
                        binding.textView.text = "첫 번째 체크박스가 체크되었습니다"
                    } else {
                        binding.textView.text = "첫 번째 체크박스가 해제되었습니다"
                    }
                }
                R.id.checkBox2 -> {
                    if (isChecked == true){
                        binding.textView.text = "두 번째 체크박스가 체크되었습니다"
                    } else{
                        binding.textView.text = "두 번째 체크박스가 해제되었습니다"
                    }
                }
            }
        }
    }
}