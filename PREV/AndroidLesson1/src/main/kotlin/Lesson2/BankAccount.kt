package com.example.kotlinfundamendals

open class BankAccount {
    var accountNumber = 0
    var accountBalance = 0.0
    constructor(number: Int, balance: Double) {
        accountNumber = number
        accountBalance = balance
    }

    open fun displayBalance()
    {
        println("Number $accountNumber")
        println("Current balance is $accountBalance")
    }
}
class SavingsAccount : BankAccount {
    var interestRate: Double = 0.0
    constructor(accountNumber: Int, accountBalance: Double) :
            super(accountNumber, accountBalance)

    constructor(accountNumber: Int, accountBalance: Double, rate: Double) :
            super(accountNumber, accountBalance) {
        interestRate = rate
    }

    fun calculateInterest(): Double
    {
        return interestRate * accountBalance
    }
    override fun displayBalance()
    {
        println("Number $accountNumber")
        println("Current balance is $accountBalance")
        println("Prevailing interest rate is $interestRate")
    }
}
fun main(args: Array<String>) {
    val savings1 = SavingsAccount(12311, 600.00, 0.07)
    println(savings1.calculateInterest())
    savings1.displayBalance()
}