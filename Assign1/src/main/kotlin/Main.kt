// Assignment 1
// Part Third
fun main(args: Array<String>){
    println("Hello")
    println("Assignment1: "+assign_a(1245))
    val myList = listOf(1, 2, 3, 4, 5)
    val myArray: Array<Int> = myList.toTypedArray()
    println("Assignment2: "+assign_b(myArray))
    assign_c()
    Part4().main()
}

fun assign_a(num: Int): Int {
    var res:Int
    var str:String
    val charArray = charArrayOf(num.toString().get(0), num.toString().get(num.toString().length-1))
    str = String(charArray)
    res = str.toInt()
    return res
}

fun assign_b(arr: Array<Int>): Int {
    var res = 0
    for (i in arr){
        if (i%2 != 0){
            res += i*i
        }
    }
    return res
}

fun assign_c(){
    var weight: Double?
    do {
        print("Enter a Weight : ")
        weight = readLine()!!.toDoubleOrNull()
        if (weight == null) println("Try again")
    } while (weight == null)
    println("""Choice Planet Relative gravity
        1 Venus 0.78
        2 Mars 0.39
        3 Jupiter 2.65
        4 Saturn 1.17
        5 Uranus 1.05
        6 Neptune 1.23""".trimMargin())
    val choice = readLine()
    val res = when (choice) {
        "1" -> weight * 0.78
        "2" -> weight * 0.39
        "3" -> weight * 2.65
        "4" -> weight * 1.17
        "5" -> weight * 1.05
        "6" -> weight * 1.23
        else -> "$choice choice is invalid"
    }
    println("Your weight on the that plane: "+res)
}

// Part Fourth
open class Book{
    private var title: String = ""
    private var author: String = ""
    private var price: Double = 0.0
    constructor(t: String, a: String, p: Double){
        this.title = t
        this.author = a
        this.price = p
    }

    open fun read(){
        println("Reading Paper book")
    }
    // Getter and Setter for title
    fun getTitle(): String {
        return this.title
    }
    fun setTitle(newTitle: String) {
        this.title = newTitle
    }
    // Getter and Setter for author
    fun getAuthor(): String {
        return this.author
    }
    fun setAuthor(newAuthor: String) {
        this.author = newAuthor
    }
    // Getter and Setter for price
    fun getPrice(): Double {
        return this.price
    }
    fun setPrice(newPrice: Double) {
        this.price = newPrice
    }
}
class EBook : Book {
    private var fileType : String = ""

    constructor(t: String, a: String, p: Double, fileT: String) : super(t, a, p){
        this.fileType = fileT
    }
    override fun read() {
        println("Read from Electronic Device")
    }
    fun getFiletype(): String {
        return this.fileType
    }
    fun setFiletype(newFiletype: String) {
        this.fileType = newFiletype
    }
}
class Part4 {
    fun main() {
        val paperBook = Book("Sample Title", "Sample Author", 29.99)
        val eBook = EBook("Sample EBook", "EBook Author", 19.99, "pdf")

        println("Paper Book Title: ${paperBook.getTitle()}")
        println("Paper Book Author: ${paperBook.getAuthor()}")
        println("Paper Book Price: ${paperBook.getPrice()}")

        println("EBook Title: ${eBook.getTitle()}")
        println("EBook Author: ${eBook.getAuthor()}")
        println("EBook Price: ${eBook.getPrice()}")
        println("EBook Filetype: ${eBook.getFiletype()}")
        eBook.setPrice(4000.0)
        println("Updated EBook Price: ${eBook.getPrice()}")
        // Calling read() method for both book types
        paperBook.read()
        eBook.read()

    }
}