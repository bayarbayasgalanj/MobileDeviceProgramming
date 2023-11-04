package com.miu.lab4_task1to6

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.miu.lab4_task1to6.databinding.ActivityShoppingCategoryBinding


class ShoppingCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val username = intent.getStringExtra("USERNAME")
        binding.welcomeTextView.text = "Welcome $username!"

        binding.clothingImageView.setOnClickListener {
            Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_LONG).show()
        }
        binding.electronicsImageView.setOnClickListener {
            Toast.makeText(this, "You have chosen the Electronics category of shopping", Toast.LENGTH_LONG).show()
        }
        binding.beautyImageView.setOnClickListener {
            Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_LONG).show()
        }
        binding.foodImageView.setOnClickListener {
            Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_LONG).show()
        }
    }
}
