import com.example.kotlinfundamendals.BankAccount
import java.util.ArrayList
import java.util.Scanner

fun main(args: Array<String>) {
//    println("Hello World!")
//
//    // Try adding program arguments via Run/Debug configuration.
//    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
//
//    val scanner = Scanner(System.`in`)
//    println("Enter your Name")
//
//    var name = scanner.nextLine()
//
//    //println("You entered: " + name) // String contatenation
//    println("You entered: $name") // String template
//
//
//
//    var intArray = IntArray(5)
//    intArray[0] = 2
//    intArray[1] = 3
//
//    intArray.forEach { println(it) }

//    var list = ArrayList<String>(arrayListOf("c++", "c#"))
//    list.add("java")
//    list.forEach { println(it) }


    //println(add1(1, 2.5f))
    var a = Circle("123", "ali")
    println(a.num)
}

class Circle(val num: String, val balance: String) {

}

fun add1(x: Int, y: Int): Int {
    return x + y;
}