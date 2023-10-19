package com.example.kotlinfundamendals

// Strings.kt - String Methods
fun main(args: Array<String>) {
    val str = "May the force be with you."
    println(str)
// Multiline String
    val rawCrawl = """|A long time ago,
    |in a galaxy
    |far, far, away...
    |BUMM BUMM BUMMMM""".trimMargin()
    println(rawCrawl)


// Checking Equality
    val contentEquals = str.contentEquals("May the force be with you.")
    println(contentEquals)

    val contains = str.contains("Force", false)
    println(contains)
    val uppercase = str.toUpperCase()
    val lower = str.toLowerCase()

    println(uppercase)
    println(lower)

    val num = 6
    val stringNum = num.toString()
    println(stringNum)

    val subsequence = str.subSequence(4, 13)
    println(subsequence)

    val luke = "Luke Skywalker"
    val lightSaberColor = "green"
    val vehicle = "landspeeder"
    val age = 27
    // String Templates
    println("$luke has a $lightSaberColor lightsaber and drives a $vehicle and is $age years old")
    println("Lukes full name $luke has ${luke.toUpperCase()} characters")

}