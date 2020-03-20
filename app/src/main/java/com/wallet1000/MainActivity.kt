package com.wallet1000

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ismaeldivita.chipnavigation.ChipNavigationBar
//import sun.jvm.hotspot.utilities.IntArray
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        var money = 0

        val bottomNavigation = findViewById<ChipNavigationBar>(R.id.menu_bar)

        bottomNavigation.setOnItemSelectedListener { id ->
            val option = when(id) {
                R.id.home
            }
        }
//        val moneyBtn1 = findViewById<ImageButton>(R.id.button10000)
//        val moneyBtn2 = findViewById<ImageButton>(R.id.button1000)
//        val moneyBtn3 = findViewById<ImageButton>(R.id.button100)
//        val saveBtn = findViewById<ImageButton>(R.id.saveButton)
//        val total = findViewById<TextView>(R.id.totalMoney)
//        val current = findViewById<TextView>(R.id.CurrentMoney)
//        var db = DatabaseHandler(context)
//
//        moneyBtn1.setOnClickListener {
//            money += 10000
//            total.text = "$money"
//        }
//
//        moneyBtn2.setOnClickListener {
//            money += 1000
//            total.text = "$money"
//
//           // var data = db.readData()
//            //current.text = data.get(0).money.toString()
//        }
//
//        moneyBtn3.setOnClickListener {
//            money += 100
//            total.text = "$money"
//        }
//
//        saveBtn.setOnClickListener{
//            val now = LocalDateTime.now()
//
//            var date = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//            var time = DateTimeFormatter.ofPattern("HH:MM")
//
//            val dateString: String = date.format(now)
//            val timeString: String = time.format(now)
//
//
//            if (money.toString().length > 0){
//                var user = User(money,dateString,timeString)
//                db.insertData(user)
//            }
//            money = 0
//            total.text = "$money"
//        }
    }



}
