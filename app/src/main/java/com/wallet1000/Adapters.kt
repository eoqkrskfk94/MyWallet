package com.wallet1000

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wallet1000.Fragments.ProfileFragment
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

        holder.buttonDelete.setOnClickListener{
            var alertDialog = AlertDialog.Builder(context)
                .setTitle("Warning")
                .setMessage("Are you sure to Delete?")
                .setPositiveButton("Yes", DialogInterface.OnClickListener{dialog, which ->
                    if (ProfileFragment.databaseHandler.deleteRecord(user.id)){
                        record.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position,record.size)
                        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(context, "Not Deleted", Toast.LENGTH_SHORT).show()
                    }
                })
                .setNegativeButton("No", DialogInterface.OnClickListener{dialog, which -> })
                .show()
        }

//        holder.buttonUpdate.setOnClickListener {
//            val inflater = LayoutInflater.from(context)
//            val view = inflater.inflate(R.layout.lo_record_update, null)
//
//            val txtMoney : TextView = view.findViewById(R.id.editMoney)
//            val txtDate : TextView = view.findViewById(R.id.text_date)
//            val txtTime : TextView = view.findViewById(R.id.text_time)
//
//            txtDate.text = user.date
//            txtTime.text = user.time
//            txtMoney.text = user.money.toString()
//
//            val builder = AlertDialog.Builder(context)
//                .setTitle("Update record info.")
//                .setView(view)
//                .setPositiveButton("Update", DialogInterface.OnClickListener{dialog, which ->
//                    val isUpdate:Boolean = ProfileFragment.databaseHandler.updateRecord(
//                        user.id,
//                    )
//                })
//        }
    }

}
