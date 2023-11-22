// LoginActivity.kt

package com.miu.foodiepalbayar

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Initialize UI elements
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            // Perform validation (e.g., check for empty fields)
            if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
                // Display an error message or handle validation as needed
            } else {
                // Simulate authentication (replace with actual authentication logic)
                val isAuthenticated = authenticateUser(enteredUsername, enteredPassword)

                if (isAuthenticated) {
                    // Authentication successful, securely store login credentials
                    storeCredentials(enteredUsername, enteredPassword)
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()

                    // Start MainActivity
                    val mainActivityIntent = Intent(this, MainActivity::class.java)
                    startActivity(mainActivityIntent)
                    finish() // Optionally, you can finish the LoginActivity to prevent going back to it.

                } else {
                    Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_LONG).show()
                    // Authentication failed, show an error message
                }
            }
        }
    }

    // Simulated authentication logic (replace with actual logic)
    private fun authenticateUser(username: String, password: String): Boolean {
        // Replace with your authentication logic here (e.g., check against a database)
        return username == "user" && password == "password"
    }

    // Securely store login credentials in SharedPreferences
    private fun storeCredentials(username: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }
}
