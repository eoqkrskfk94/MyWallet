package com.wallet1000

fun main(){
    val hello1: String = "Hello World!" //final
    var hello2 = "Hello World!" // int,string,float,double

    hello2 = "Hello World"
    hello()

    println(hello2)

    println(hello())

}

fun hello(): String{

    return "Hello"
}