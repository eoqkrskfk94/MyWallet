package com.wallet1000

class User {

    var id: Int = 0
    var name: String = ""
    var money: Int = 0

    constructor(name:String, money:Int){
        this.name = name
        this.money = money
    }
}