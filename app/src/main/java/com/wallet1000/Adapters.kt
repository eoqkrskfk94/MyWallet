package com.wallet1000

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.records.view.*


class UserAdapter(context: Context, val record : ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    val context = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtDate = itemView.date_text
        val txtTime = itemView.time_text
        val txtMoney = itemView.money_text
        val buttonUpdate = itemView.btnUpdate
        val buttonDelete = itemView.btnDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.records,parent,false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return record.size
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val user : User = record[position]
        holder.txtDate.text = user.date
        holder.txtTime.text = user.time
        holder.txtMoney.text = user.money.toString()
    }

}
