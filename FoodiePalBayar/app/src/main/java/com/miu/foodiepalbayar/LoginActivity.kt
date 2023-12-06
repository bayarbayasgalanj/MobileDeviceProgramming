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

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {

            } else {
                val isAuthenticated = authenticateUser(enteredUsername, enteredPassword)

                if (isAuthenticated) {
                    storeCredentials(enteredUsername, enteredPassword)
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()

                    val mainActivityIntent = Intent(this, MainActivity::class.java)
                    startActivity(mainActivityIntent)
                    finish()

                } else {
                    Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun authenticateUser(username: String, password: String): Boolean {
        return username == "user" && password == "password"
    }

    private fun storeCredentials(username: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }
}