package com.wallet1000.Fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.wallet1000.DatabaseHandler

import com.wallet1000.R
import com.wallet1000.User
import kotlinx.android.synthetic.main.fragment_main.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class MainFragment : Fragment(){
    var money = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_main, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context: Context = context!!

        var db = DatabaseHandler(context)

        var now = LocalDateTime.now()
        var date = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        var time = DateTimeFormatter.ofPattern("HH:mm")
        var dateString: String = date.format(now)
        var timeString: String = time.format(now)

        textdate.text = "$dateString"
        texttime.text = "$timeString"

        currentMoney.text = "₩$money"

        textdate.setOnClickListener {
            val now_cal = Calendar.getInstance()
            val datePicker  = DatePickerDialog(context, DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.YEAR,year)
                selectedDate.set(Calendar.MONTH,month)
                selectedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                val format1 = SimpleDateFormat("yyyy-MM-dd")
                val createdDate = format1.format(selectedDate.time)
                dateString = createdDate
                textdate.text = "$dateString"

            },
                now_cal.get(Calendar.YEAR), now_cal.get(Calendar.MONTH),  now_cal.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        texttime.setOnClickListener {
            val now_clock = Calendar.getInstance()
            val timePicker = TimePickerDialog(context, TimePickerDialog.OnTimeSetListener{view, hourOfDay, min ->
                val selectedTime = Calendar.getInstance()
                selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                selectedTime.set(Calendar.MINUTE,min)
                val format2 = SimpleDateFormat("HH:MM")
                val createdTime = format2.format(selectedTime.time)
                timeString = createdTime
                texttime.text = "$timeString"

            },
                now_clock.get(Calendar.HOUR_OF_DAY), now_clock.get(Calendar.MINUTE), true)
            timePicker.show()
        }

        refreshButton.setOnClickListener{
            now = LocalDateTime.now()
            date = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            time = DateTimeFormatter.ofPattern("HH:MM")
            dateString = date.format(now)
            timeString = time.format(now)

            textdate.text = "$dateString"
            texttime.text = "$timeString"
        }

        //10000만원
        right10000.setOnClickListener{
            money += 10000
            if (money < 0){
                currentMoney.text = "₩0"
                money = 0
            }
            else{ currentMoney.text = "₩$money" }
        }

        left10000.setOnClickListener{
            money -= 10000
            if (money < 0){
                currentMoney.text = "₩0"
                money = 0
            }
            else{ currentMoney.text = "₩$money" }
        }

        //1000원
        right1000.setOnClickListener{
            money += 1000
            if (money < 0){
                currentMoney.text = "₩0"
                money = 0
            }
            else{ currentMoney.text = "₩$money" }
        }

        left1000.setOnClickListener{
            money -= 1000
            if (money < 0){
                currentMoney.text = "₩0"
                money = 0
            }
            else{ currentMoney.text = "₩$money" }
        }

        //100원
        right100.setOnClickListener{
            money += 100
            if (money < 0){
                currentMoney.text = "₩0"
                money = 0
            }
            else{ currentMoney.text = "₩$money" }
        }

        left100.setOnClickListener{
            money -= 100
            if (money < 0){
                currentMoney.text = "₩0"
                money = 0
            }
            else{ currentMoney.text = "₩$money" }
        }

        //등록하기 버튼
        btn_save.setOnClickListener{

            if (money.toString().length > 0){
                var user = User(money,dateString,timeString)
                db.insertData(user)
            }
            money = 0
            currentMoney.text = "₩$money"
        }

        //삭제하기 버튼
        btn_delete.setOnClickListener{
            money = 0
            currentMoney.text = "₩$money"
        }

    }


}
