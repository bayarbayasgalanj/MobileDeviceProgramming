package com.example.kotlinfundamendals.interfacedemo

interface MyInterface {

    val test: Int
    val pass: Int get() = 83

    // Abstract method
    fun print() : String

    // default implementation
    fun hello(name: String) {
        println("Hello there, $name!")
    }

    //static method - java static { }
    //companion also works in classes
    companion object {
        fun staticmeth() {
            println("hello static method")
        }
    }
}
