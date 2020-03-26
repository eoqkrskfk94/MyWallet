package com.wallet1000.Fragments

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
        var button10000_up = view.findViewById<ImageButton>(R.id.right10000)
        var button10000_down = view.findViewById<ImageButton>(R.id.left10000)
        var button1000_up = view.findViewById<ImageButton>(R.id.right1000)
        var button1000_down = view.findViewById<ImageButton>(R.id.left1000)
        var button100_up = view.findViewById<ImageButton>(R.id.right100)
        var button100_down = view.findViewById<ImageButton>(R.id.left100)
        var buttonSave = view.findViewById<ImageButton>(R.id.btn_save)
        var buttonDelete = view.findViewById<ImageButton>(R.id.btn_delete)
        var total = view.findViewById<TextView>(R.id.currentMoney)
        var now_date = view.findViewById<Button>(R.id.textdate)
        var now_time = view.findViewById<Button>(R.id.texttime)
        var db = DatabaseHandler(context)



        val now = LocalDateTime.now()
        var date = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        var time = DateTimeFormatter.ofPattern("HH:MM")
        val dateString: String = date.format(now)
        val timeString: String = time.format(now)

        now_date.text = "$dateString"
        now_time.text = "$timeString"

        total.text = "₩$money"

        //10000만원
        button10000_up.setOnClickListener{
            money += 10000
            if (money < 0){ total.text = "0" }
            else{ total.text = "₩$money" }
        }

        button10000_down.setOnClickListener{
            money -= 10000
            if (money < 0){ total.text = "0" }
            else{ total.text = "₩$money" }
        }

        //1000원
        button1000_up.setOnClickListener{
            money += 1000
            if (money < 0){ total.text = "0" }
            else{ total.text = "₩$money" }
        }

        button1000_down.setOnClickListener{
            money -= 1000
            if (money < 0){ total.text = "0" }
            else{ total.text = "₩$money" }
        }

        //100원
        button100_up.setOnClickListener{
            money += 100
            if (money < 0){ total.text = "0" }
            else{ total.text = "₩$money" }
        }

        button100_down.setOnClickListener{
            money -= 100
            if (money < 0){ total.text = "0" }
            else{ total.text = "₩$money" }
        }

        //등록하기 버튼
        buttonSave.setOnClickListener{

            if (money.toString().length > 0){
                var user = User(money,dateString,timeString)
                db.insertData(user)
            }
            money = 0
            total.text = "₩$money"
        }

        //삭제하기 버튼
        buttonDelete.setOnClickListener{
            money = 0
            total.text = "₩$money"
        }

    }


}
