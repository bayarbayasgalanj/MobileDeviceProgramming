package com.example.kotlinfundamendals.inheritancedemo

fun main(args: Array<String>) {

    // Create a BankAccount Account with 6% interest rate
    val savingsAccount = SavingsAccount("64524627", "John", 6.0)
    savingsAccount.depositeMoney(1000.0)
    savingsAccount.depositInterest()
    savingsAccount.displayBalance()

    // Create a Bank Account
    val bc= BankAccount("64524627", "Kenady")
    bc.depositeMoney(2000.0)
    bc.depositInterest()
    bc.displayBalance()


}
