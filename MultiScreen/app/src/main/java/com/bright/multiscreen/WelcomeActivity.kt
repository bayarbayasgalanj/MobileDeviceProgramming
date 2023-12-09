package com.bright.multiscreen
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val textView: TextView = findViewById(R.id.textView)
        val username = intent.getStringExtra("username")
        textView.text = "Welcome $username"
    }
}
