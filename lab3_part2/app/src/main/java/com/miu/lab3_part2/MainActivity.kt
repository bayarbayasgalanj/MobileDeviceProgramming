package com.miu.lab3_part2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miu.lab3_part2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // Using view binding to interact with the views
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Set up listeners for your buttons using the binding
        binding.signInButton.setOnClickListener {
            // Handle sign in
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            signIn(email, password)
        }

        binding.createAccountButton.setOnClickListener {
            // Handle account creation
            startAccountCreation()
        }
    }

    private fun signIn(email: String, password: String) {
        // Logic for signing in
    }

    private fun startAccountCreation() {
        // Logic for starting account creation
    }
}


