package com.bright.multiscreen
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val usernameEditText: EditText = findViewById(R.id.editTextText)
        val passwordEditText: EditText = findViewById(R.id.editTextTextPassword)
        val loginButton: Button = findViewById(R.id.button)
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (username == "mickey" && password == "mickey") {
                val intent = Intent(this, WelcomeActivity::class.java).apply {
                    putExtra("username", username)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
