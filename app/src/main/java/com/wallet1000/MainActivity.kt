package com.wallet1000

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var money = 0

        val moneyBtn1 = findViewById<ImageButton>(R.id.button10000)
        val moneyBtn2 = findViewById<ImageButton>(R.id.button1000)
        val moneyBtn3 = findViewById<ImageButton>(R.id.button100)
        val total = findViewById<TextView>(R.id.totalMoney)

        moneyBtn1.setOnClickListener {
            money += 10000
            total.text = "$money"
        }

        moneyBtn2.setOnClickListener {
            money += 1000
            total.text = "$money"
        }

        moneyBtn3.setOnClickListener {
            money += 100
            total.text = "$money"
        }
    }

}
