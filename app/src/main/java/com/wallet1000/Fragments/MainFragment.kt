package com.wallet1000.Fragments

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView

import com.wallet1000.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), View.OnClickListener{
    var money = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_main, container, false)


        val btn: ImageButton = view.findViewById(R.id.btn10000)
        var text: TextView = view.findViewById(R.id.currentMoney)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var button10000 = view.findViewById<ImageButton>(R.id.btn10000)
        var total = view.findViewById<TextView>(R.id.currentMoney)

        button10000.setOnClickListener{
            money += 10000
            total.text = "$money"
        }
    }

    override fun onClick(v: View?) {

        when (v?.id){
            R.id.btn10000 -> {
                money += 10000
                System.out.println(money)
                currentMoney.text = "$money"
            }
        }
    }

}
