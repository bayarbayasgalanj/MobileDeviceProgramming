package com.miu.lab4_task1to6

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miu.lab4_task1to6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_REGISTER = 1
    private lateinit var binding: ActivityMainBinding

    private val users = arrayListOf<User>(
        User("John", "Doe", "john@miu.com", "123456"),
        User("Jane", "Smith", "jane@miu.com", "123456"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signInButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            signIn(email, password)
        }
        binding.createAccountButton.setOnClickListener {
            startAccountCreation()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_REGISTER && resultCode == RESULT_OK) {
            val newUser = data?.getSerializableExtra("NEW_USER") as? User
            if (newUser != null) {
                users.add(newUser)
            }
        }
    }

    private fun signIn(email: String, password: String) {
//        println(newUser)
//        if (newUser!=null){
//            users.add(newUser)
//        }
//        users.forEach  { user ->
//            println("User: ${user.firstName} ${user.lastName} ${user.username} ${user.password}")
//        }
        println("${email}  ====== ${password}")
        val user = users.find { it.username == email && it.password == password }
        if (user != null) {
            val intent = Intent(this, ShoppingCategoryActivity::class.java).apply {
                putExtra("USERNAME", email)
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_LONG).show()
        }
    }

    private fun startAccountCreation() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE_REGISTER)
    }
}
