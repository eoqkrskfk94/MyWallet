package com.wallet1000

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "User"
val COL_ID = "ID"
val COL_DATE = "date"
val COL_TIME = "time"
val COL_MONEY = "money"


class DatabaseHandler(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_DATE + " VARCHAR(256)," +
                COL_TIME + " VARCHAR(256)," +
                COL_MONEY + " INTEGER)"


        db?.execSQL(createTable)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(user : User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_DATE,user.date)
        cv.put(COL_TIME,user.time)
        cv.put(COL_MONEY,user.money)
        var result = db.insert(TABLE_NAME,null,cv)

    }

    fun readData() :MutableList<User>{
        var list: MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)

        if (result.moveToFirst()){
            do{
                println("works")
                var user = User()
                user.date = result.getString(result.getColumnIndex(COL_DATE))
                user.time = result.getString(result.getColumnIndex(COL_TIME))
                user.money = result.getString(result.getColumnIndex(COL_MONEY)).toInt()
                list.add(user)

            }while(result.moveToNext())
        }

        result.close()
        db.close()

        return list
    }

    fun updateDate(money: Int){
        val db = this.writableDatabase
        //db.update()
    }
}