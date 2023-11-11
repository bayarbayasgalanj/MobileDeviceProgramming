package com.miu.lab5_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miu.lab5_part2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var product_images = intArrayOf(
        R.drawable.product_img1,
        R.drawable.product_img2,
        R.drawable.product_img3,
        R.drawable.product_img4,
    )
    var product_logos = intArrayOf(
        R.drawable.product_logo1,
        R.drawable.product_logo2,
        R.drawable.product_logo3,
        R.drawable.product_logo4,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewCartButton: Button = findViewById(R.id.viewCartButton)
        viewCartButton.setOnClickListener {
            viewCart()
        }
        val homeButton: Button = findViewById(R.id.backHomeButton)
        homeButton.setOnClickListener {
            backHomeButton()
        }
        val products = ArrayList<Product>()
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0, 0, 0))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00, 1, 1))
        products.add(Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00, 2, 2))
        products.add(Product("iPhone 15 pro max", "256GD Hard\n8 GB Ram", 199.00, 3,3))
        part2(products)
    }

    fun part2(products: ArrayList<Product>) {
        binding.recyclerView1.layoutManager = LinearLayoutManager(this)
        var adapter = ProductAdapter(this, products, product_images, product_logos)
        binding.recyclerView1.adapter = adapter
        val cartRecyclerView: RecyclerView = findViewById(R.id.recyclerViewCart)
        val backHomeButton: Button = findViewById(R.id.backHomeButton)
        backHomeButton.visibility = View.GONE
        cartRecyclerView.visibility = View.GONE
    }
    fun backHomeButton(){
        val recyclerView1: RecyclerView = findViewById(R.id.recyclerView1)
        val cartRecyclerView: RecyclerView = findViewById(R.id.recyclerViewCart)
        val backHomeButton: Button = findViewById(R.id.backHomeButton)
        val viewCartButton: Button = findViewById(R.id.viewCartButton)
        recyclerView1.visibility = View.VISIBLE
        viewCartButton.visibility = View.VISIBLE
        backHomeButton.visibility = View.GONE
        cartRecyclerView.visibility = View.GONE

    }
    private fun viewCart() {
        val cartItems = CartManager.getCartItems()
        val cartRecyclerView: RecyclerView = findViewById(R.id.recyclerViewCart)
        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        cartRecyclerView.adapter = CartAdapter(this, ArrayList(cartItems), product_images, product_logos)

        val recyclerView1: RecyclerView = findViewById(R.id.recyclerView1)
        val backHomeButton: Button = findViewById(R.id.backHomeButton)
        val viewCartButton: Button = findViewById(R.id.viewCartButton)
        recyclerView1.visibility = View.GONE
        viewCartButton.visibility = View.GONE
        backHomeButton.visibility = View.VISIBLE
        cartRecyclerView.visibility = View.VISIBLE
    }
}