package kr.co.si312.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kr.co.si312.dice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val diceImage1 =  binding.dice1
        val diceImage2 = binding.dice2

        binding.button.setOnClickListener{

            Toast.makeText(this,"주사위 Go!", Toast.LENGTH_SHORT).show()

            Log.d("MainActivity", Random.nextInt(1,6).toString())
            Log.d("MainActivity", Random.nextInt(1,6).toString())

            val number1 = Random.nextInt(1,7)
            val number2 = Random.nextInt(1,7)

            if (number1 == 1){
                diceImage1.setImageResource(R.drawable.dice_1)
            } else if (number1 == 2){
                diceImage1.setImageResource(R.drawable.dice_2)
            } else if (number1 == 3){
                diceImage1.setImageResource(R.drawable.dice_3)
            } else if (number1 == 4){
                diceImage1.setImageResource(R.drawable.dice_4)
            }else if (number1 == 5){
                diceImage1.setImageResource(R.drawable.dice_5)
            }else {
                diceImage1.setImageResource(R.drawable.dice_6)
            }

            if (number2 == 1){
                diceImage2.setImageResource(R.drawable.dice_1)
            } else if (number2 == 2){
                diceImage2.setImageResource(R.drawable.dice_2)
            } else if (number2 == 3){
                diceImage2.setImageResource(R.drawable.dice_3)
            } else if (number2 == 4){
                diceImage2.setImageResource(R.drawable.dice_4)
            }else if (number2 == 5){
                diceImage2.setImageResource(R.drawable.dice_5)
            }else {
                diceImage2.setImageResource(R.drawable.dice_6)
            }


        }

    }
}