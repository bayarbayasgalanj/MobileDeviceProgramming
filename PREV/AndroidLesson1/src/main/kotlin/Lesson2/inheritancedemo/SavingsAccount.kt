package com.example.kotlinfundamendals.inheritancedemo

class SavingsAccount (accountNumber: String, accountName: String, val interestRate: Double) :
    BankAccount(accountNumber, accountName) {

    override fun depositInterest() {
        val interest = balance * interestRate / 100
        depositeMoney(interest);
    }

}
