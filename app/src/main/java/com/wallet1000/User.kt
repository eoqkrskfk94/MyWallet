package com.wallet1000

class User {

    var money: Int = 0
    var date: String = ""
    var time: String = ""

    constructor(money:Int, date:String, time:String){
        this.money = money
        this.date = date
        this.time = time
    }

    constructor(){

    }
}