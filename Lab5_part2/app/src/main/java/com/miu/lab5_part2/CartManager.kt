package com.miu.lab5_part2

// Import statements here

object CartManager {
    private val cartItems = mutableListOf<Cart>()

    fun addToCart(newItem: Cart) {
        val existingItem = cartItems.find { it.product_id == newItem.product_id }
        if (existingItem != null) {
            // Update the existing item's quantity and total price
            existingItem.product_qty += newItem.product_qty
            existingItem.product_price_total = existingItem.product_qty * existingItem.product_price
        } else {
            // Add the new item
            cartItems.add(newItem)
        }
    }

    fun getCartItems(): List<Cart> = cartItems

    // Additional methods like remove item, clear cart, etc., can be added here.
}
