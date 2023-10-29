package com.miu.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.miu.lab2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var arr = arrayOf(
        "Hamburger", "Pizza",
        "Mexican", "American", "Chinese"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonDecide.setOnClickListener{
//            Log.v("VerboseTag", "======-------+++++++++")
            val random = java.util.Random()
            val randomIndex = random.nextInt(arr.size)
            val randomElement = arr[randomIndex]
            println("Random element from the list: $randomElement")
            showMsg("$randomElement")
        }
        binding.buttonAddFood.setOnClickListener{
            val inputText = binding.textInput.text.toString()
            Log.v("VerboseTag", "======-------+++++++++ $inputText")
            val newArr = Array(arr.size + 1) { "" }
            for (i in arr.indices) {
                newArr[i] = arr[i]
            }
            newArr[arr.size] = inputText
            arr = newArr
        }
    }
    fun showMsg(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        binding.textView.text = msg
    }
}