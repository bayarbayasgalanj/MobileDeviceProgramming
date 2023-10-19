package com.example.kotlinfundamendals

class Item{
    var name:String
    var price:Double = 0.0
    constructor(name:String) {
        this.name = name
    }
    constructor(name:String, price:Double) {
        this.name = name
        this.price = price
    }
    override fun toString(): String{
        return name + " " + price
    }
}
