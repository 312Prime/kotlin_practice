package kr.co.si312.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kr.co.si312.recyclerview.databinding.ActivityMainBinding
import kr.co.si312.recyclerview.databinding.RowBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var imgRes = intArrayOf(
        R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4,
        R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    )
    var data1 = arrayOf("토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        class BenefitViewHolder(private  val binding: RowBinding):
            RecyclerView.ViewHolder(binding.root){
            val rowImageView1 = binding.rowImageView
            val rowTextView1 = binding.rowTextView
        }


    }

    //RecyclerView의 Adapter 클래스
    inner class RecyclerAdapter {


        //ViewHolder 클래스
        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView){
            //항목 View 내부의 View 객체의 주소값을 닫는다.
            val rowImageView =
            val rowTextView =
        }
    }
}
class BenefitViewHolder(private  val binding: RowBinding):
        RecyclerView.ViewHolder(binding.root){
            val rowImageView = binding.rowImageView
            val rowTextView = binding.rowTextView
        }