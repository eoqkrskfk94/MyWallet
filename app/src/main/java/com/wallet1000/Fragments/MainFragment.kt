package com.wallet1000.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

import com.wallet1000.R
import kotlinx.android.synthetic.main.fragment_home.*

class MainFragment : Fragment() , View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_main, container, false)
        var money = 0
        val btn10000 : ImageButton = view.findViewById(R.id.button10000)
        btn10000.setOnClickListener(this)

        return view


    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1000 -> {

            }

            else -> {
            }
        }
    }

}
