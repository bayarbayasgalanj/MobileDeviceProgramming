package com.example.kotlinfundamendals

   fun main(args: Array<String>) {
        val acc1 = Account(1234,5000.45);
        acc1.displayBalance();
        var bal = acc1.balanceLessFees; // Calling getter
        acc1.displayBalance();
        acc1.balanceLessFees=1000.00 // using setter
        acc1.displayBalance();
       println("Fee :  $acc1.fees") // calling getter
    }
