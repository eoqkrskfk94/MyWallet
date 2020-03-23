package com.wallet1000.Fragments

import android.content.Context
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.wallet1000.DatabaseHandler

import com.wallet1000.R
import com.wallet1000.User
import kotlinx.android.synthetic.main.fragment_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MainFragment : Fragment(){
    var money = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_main, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context: Context = context!!
        var button10000 = view.findViewById<ImageButton>(R.id.btn10000)
        var button1000 = view.findViewById<ImageButton>(R.id.btn1000)
        var button100 = view.findViewById<ImageButton>(R.id.btn100)
        var buttonSave = view.findViewById<ImageButton>(R.id.btn_save)
        var total = view.findViewById<TextView>(R.id.currentMoney)
        var db = DatabaseHandler(context)

        button10000.setOnClickListener{
            money += 10000
            if (money < 0){ total.text = "0" }
            else{ total.text = "$money" }
        }

        button1000.setOnClickListener{
            money += 1000
            if (money < 0){ total.text = "0" }
            else{ total.text = "$money" }
        }

        button100.setOnClickListener{
            money += 100
            if (money < 0){ total.text = "0" }
            else{ total.text = "$money" }
        }

        buttonSave.setOnClickListener{
            val now = LocalDateTime.now()
            var date = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            var time = DateTimeFormatter.ofPattern("HH:MM")

            val dateString: String = date.format(now)
            val timeString: String = time.format(now)


            if (money.toString().length > 0){
                var user = User(money,dateString,timeString)
                db.insertData(user)
            }
            money = 0
            total.text = "$money"
        }
    }

//    override fun onClick(v: View?) {
//
//        when (v?.id){
//            R.id.btn10000 -> {
//                money += 10000
//                System.out.println(money)
//                currentMoney.text = "$money"
//            }
//        }
//    }

}
