package com.example.kotlinfundamendals.inheritancedemo

open class BankAccount(val accountNumber: String, val accountName: String) {
    var balance : Double = 0.0



    fun depositeMoney(amount: Double): Boolean {
        if(amount > 0) {
            balance += amount
            return true
        } else {
            return false
        }
    }

    fun withdrawMoney(amount: Double): Boolean {
        if(amount > balance) {
            return false
        } else {
            balance -= amount
            return true
        }
    }
    fun displayBalance(){
        println("Name $accountName")
        println("Number $accountNumber")
        println("Current balance is $balance")

    }

    open fun depositInterest(){
        val interest = balance * 0.02 / 100
        depositeMoney(interest);
    }
}