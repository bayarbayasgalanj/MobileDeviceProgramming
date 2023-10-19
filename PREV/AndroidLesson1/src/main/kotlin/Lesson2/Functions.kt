package com.example.kotlinfundamendals

fun main(args: Array<String>) {
    var res = multiply(5,50) // Function calling
    println("Result : $res")
    // Local Function
    val name = "John"
    val count = 5
    fun displayString() {
        for (index in 1..count) {
            println(name)
        }
    }
    displayString()

    // Making use of Default arguments and passing values
    var message = buildMessageFor(count = 10)
    println(message)

    message = buildMessageFor("John") // Valid
    println(message)
    // message = buildMessageFor(10) // Invalid
    message = buildMessageFor("Jack",50) // Valid
    println(message)
}
fun multiply(x: Int, y: Int): Int {
    return x * y
}
// Example for Default Arguments
fun buildMessageFor(name: String = "Customer", count: Int = 0): String {
    return("$name, you are customer number $count")
}