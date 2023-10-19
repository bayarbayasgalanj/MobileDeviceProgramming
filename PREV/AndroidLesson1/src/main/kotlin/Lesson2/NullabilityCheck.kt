package com.example.kotlinfundamendals

fun main(args: Array<String>) {

    var username : String = "Anne Mathew"
   //  username = null // Compilation Error - Null can not be a value of a non-null type String

    var nullableusername : String? = "Anne Mathew"

   // nullableusername.length // Gives compilation error
    //traditional Null Check - Method 1
    var length = 0
    if (nullableusername != null) {
        length = nullableusername.length
    } else {
        length = -1
    }
    println(length)

    //traditional Null Check - Method 2
    val l = if (nullableusername != null) nullableusername.length else -1
    println(l)

    // Safe Call Operator ? - Kotlin Way 1
    println(nullableusername?.length)

    // Elvis Operator - Kotlin Way 2
    nullableusername = null // Can assign null value
    val len = nullableusername?.length ?: -1
    println(len)
    val nousername = nullableusername ?: "No one knows me..."
    println(nousername)
    var nodata : String? =null
    // Not Null Assertion - !! ( Recommended to use only the input is not null)
    println(username!!.toUpperCase())
   //  println(nodata!!.toUpperCase()) // throws KotlinNullPointerException

}