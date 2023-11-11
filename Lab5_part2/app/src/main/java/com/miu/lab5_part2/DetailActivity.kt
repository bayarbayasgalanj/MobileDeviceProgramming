package com.miu.lab5_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.miu.lab5_part2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val homeButton: Button = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
        }
        if (intent.hasExtra("image") && intent.hasExtra("name") && intent.hasExtra("desc")) {
            var ig = intent.getIntExtra("image", 0)
            var name = intent.getStringExtra("name")
            var desc = intent.getStringExtra("desc")
            var price = intent.getStringExtra("price")
            binding.name.text = name.toString()
            binding.desc.text = desc.toString()
            binding.price.text = price.toString()
            binding.imageView.setImageResource(ig)
        }
    }
}