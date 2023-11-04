package com.miu.lab3_part2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miu.lab3_part2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.signInButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            signIn(email, password)
        }

        binding.createAccountButton.setOnClickListener {
            startAccountCreation()
        }
    }

    private fun signIn(email: String, password: String) {

    }

    private fun startAccountCreation() {

    }
}


