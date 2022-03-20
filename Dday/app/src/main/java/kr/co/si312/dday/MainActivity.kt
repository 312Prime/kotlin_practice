package kr.co.si312.dday

import android.app.AppComponentFactory
import android.app.DatePickerDialog
import android.icu.util.TimeUnit
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

        val calendar_start = Calendar.getInstance()
        val calendar_end = Calendar.getInstance()

        StartButton.setOnClickListener {

            val today = GregorianCalendar()
            val year =  today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this,object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayofMonth: Int) {

                    startDate = year.toString() + (month+1).toString() + dayofMonth.toString()

                    calendar_start.set(year, month+1, dayofMonth)

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

                    calendar_end.set(year, month+1, dayofMonth)

                    val finalDate = java.util.concurrent.TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)

                    val textArea = findViewById<TextView>(R.id.finalDate)

                    textArea.setText(finalDate.toString())

                }

            },year,month,day)
            dlg.show()

        }
    }
}