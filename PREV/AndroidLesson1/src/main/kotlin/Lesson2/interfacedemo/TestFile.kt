package com.example.kotlinfundamendals.interfacedemo

fun main(args: Array<String>) {
    val obj = InterfaceImp()

    println("test = ${obj.test}")
    print("Calling hello(): ")

    obj.hello("Tim")

    print("Calling and printing print(): ")
    println(obj.print())
}