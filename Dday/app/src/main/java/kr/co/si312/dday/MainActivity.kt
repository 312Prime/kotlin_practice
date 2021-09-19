package kr.co.si312.dday

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val StartButton = findViewById<Button>(R.id.StartBtn)
        val EndButton = findViewById<Button>(R.id.EndBtn)

        var startDate = ""
        var endDate = ""

        StartButton.setOnClickListener {

            val today = GregorianCalendar()
            val year =  today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this,object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayofMonth: Int) {

                    startDate = "${year}${month}${dayofMonth}"
                    Log.d("day : ", startDate)

                }

            },year,month,day)
            dlg.show()
        }

        EndButton.setOnClickListener {
            val today = GregorianCalendar()
            val year =  today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this,object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayofMonth: Int) {

                    //endDate = "${year}${month}${dayofMonth}"
                    endDate = year.toString() + (month+1).toString() + dayofMonth.toString()
                    Log.d("day : ", endDate)

                    findViewById<TextView>(R.id.finalDate).setText((endDate.toInt()-startDate.toInt()+1).toString())

                }

            },year,month,day)
            dlg.show()

        }
    }
}