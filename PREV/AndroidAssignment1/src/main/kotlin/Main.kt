fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    //Problem 3a
    convertAmount()

    //Problem 3b
    println("sum " + sumEvenSquared(intArrayOf(1,2,3,4,6,5)))

    //Problem 3c
    weightCalc()

    //Problem 4
    Test().main()
}


//Problem 3a
//Develop a program to get following output: 11.56
//11 dollars
//2 quarters
//0 dimes
//1 nickels
//1 pennies
fun convertAmount() {
    var number: Double?
    do {
        print("Enter an amount : ")
        number = readLine()!!.toDoubleOrNull()
        if (number == null) println("not a valid amount, try again")
    } while (number == null)

    val amount = number.toDouble()
    val dollars = amount.toInt()
    var balance: Int = ((amount-dollars)*100).toInt()
    val quarters = balance/25
    balance -= quarters*25
    val dimes = balance/10
    balance -= dimes*10
    val nickles = balance/5
    val penies = balance - nickles*5
    println("$dollars dollars")
    println("$quarters quarters")
    println("$dimes dimes")
    println("$nickles nickles")
    println("$penies penies")
}


//Problem 3b
//Write a function to find the sum of even squared values in the given array of integers.
//Example: Arrays contains {1, 2, 3, 4, 6, 5} Output:2 + 4 +6 → 1+9+25 = 56.
fun sumEvenSquared(n: IntArray) : Int {
    var sum = 0
    for (i in n) {
        if (i % 2 == 0) sum += i*i
    }
    return sum;
}

/*
Problem 3c
1 Venus 0.78
2 Mars 0.39
3 Jupiter 2.65
4 Saturn 1.17
5 Uranus 1.05
6 Neptune 1.23
* */
fun weightCalc() {
    var input: Double?
    do {
        print("Enter an input Weight : ")
        input = readLine()!!.toDoubleOrNull()
        if (input == null) println("not a valid amount, try again")
    } while (input == null)

    //Weight = Input * Relative gravity
    println("""Choice Planet Relative gravity
        1 Venus 0.78
        2 Mars 0.39
        3 Jupiter 2.65
        4 Saturn 1.17
        5 Uranus 1.05
        6 Neptune 1.23""".trimMargin())
    val choice = readLine()
    val weight = when (choice) {
        "1" -> input * 0.78
        "2" -> input * 0.39
        "3" -> input * 2.65
        "4" -> input * 1.17
        "5" -> input * 1.05
        "6" -> input * 1.23
        else -> "$choice choice is invalid"
    }
    println(weight)
}


/*
Problem 4
Practice OO Concepts (Class, Object, Getters and Setters, Inheritance, Override etc.,

a. Create a class Book with the fields title, author and price. Make a constructor
which initialize all the fields. Add a behavior with read() and just print a
message “Reading Paper book”.

b. Create a subclass EBook from Book, include additional attribute filetype as
String. (ex: pdf, epub, kindle etc.,). Override read() method and print the
message as “Read from Electronic Device”.

c. Write a Test class. Create object for Book and EBook. Make use of getters and
setters.
* */
open class Book {
    var title: String = ""
    var author: String = ""
    var price: Int = 0

    constructor(title: String, author: String, price: Int) {
        this.title = title
        this.author = author
        this.price = price
    }

    open fun read(){
        println("Reading Paper book")
    }

    override fun toString(): String {
        return "Book(title='$title', author='$author', price=$price)"
    }
}

class EBook : Book {
    var fileType : String = ""
    val extraCharge: Int = 10
    var discountFee: Int
        get() {
            return price - 10
        }
        set (v) {
            price += v - extraCharge
        }


    constructor(title: String, author: String, price: Int, file: String) : super(title, author, price) {
        this.fileType = file
    }

    override fun read() {
        println("Read from Electronic Device")
    }

    override fun toString(): String {
        return "EBook(title='$title', author='$author', price=$price, fileType='$fileType', extraCharge=$extraCharge, discountFee=$discountFee)"
    }


}

class Test {
    fun main() {
        val obj = Book("hello", "kim", 20)
        val obj2 = EBook("hello2", "kim", 20, "pdf")

        obj.read()
        obj2.read()

        obj.author = "Ali"
        obj2.author = "James"
        obj.read()
        obj2.read()

        println(obj)
        println(obj2)

        //using getter and setter below
        obj2.discountFee = 5
        println(obj2)
    }
}