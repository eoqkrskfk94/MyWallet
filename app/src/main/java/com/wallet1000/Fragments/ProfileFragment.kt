package com.wallet1000.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wallet1000.DatabaseHandler

import com.wallet1000.R
import com.wallet1000.User
import com.wallet1000.UserAdapter
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context: Context = context!!
        var db = DatabaseHandler(context)

        fun viewRecords(){
            val recordslist : ArrayList<User> = db.getRecords(context)
            val adapter = UserAdapter(context, recordslist)
            val display : RecyclerView = view.findViewById(R.id.display_records)
            display.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager
            display.adapter
        }

        viewRecords()









    }



}
