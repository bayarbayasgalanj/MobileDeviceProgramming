package com.example.kotlinfundamendals

fun main(args: Array<String>) {
    // Print the numbers 1 to 5
    for (index in 1..5) {
        println("Value of index is $index")
    }
    // Print each of the characters in the specified string
    for (i in "Hello") {
        println("Value of index is $i")
    }

    // Print 100 to 90 decreasing order
    for (index in 100 downTo 90) {
        print("$index.. ")
    }
    // until function operates from start to end-1 value
    println()
    for (index in 1 until 10) {
        print("$index.. ")
    }
    println()
    // Print 0.. 10.. 20.. 30.. 40.. 50.. 60.. 70.. 80.. 90..
    for (index in 0 until 100 step 10) {
        print("$index.. ")
    }
    // Working with Strings
    var daysOfWeek = listOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
    for(index in daysOfWeek){
        println(index)
    }
    for ((index, value) in daysOfWeek.withIndex()) {
        println("the element at $index is $value")
    }

    // Print using foreach with single spacing
    daysOfWeek.forEach{print("$it ")}
    println()
    repeat(4){println("Hello World!")}
}
