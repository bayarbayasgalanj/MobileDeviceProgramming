package com.example.kotlinfundamendals

fun main(args: Array<String>) {

    var i1 = Item("Lenovo Tab 4", 209.99)
    println(i1)
    var i2 = Item("Samsung Galaxy")
    // Making use of setter
    i2.price = 234.56
    // Make use of getters
    println("${i2.name} is \$${i2.price} worth")
}