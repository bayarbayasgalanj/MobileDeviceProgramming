package com.miu.lab5_part1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var radioGroupQ1: RadioGroup
    private lateinit var checkBoxQ2Option1: CheckBox
    private lateinit var checkBoxQ2Option2: CheckBox
    private lateinit var checkBoxQ2Option3: CheckBox
    private lateinit var checkBoxQ2Option4: CheckBox

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroupQ1 = findViewById(R.id.radio_group_question1)
        checkBoxQ2Option1 = findViewById(R.id.checkbox_option1_question2)
        checkBoxQ2Option2 = findViewById(R.id.checkbox_option2_question2)
        checkBoxQ2Option3 = findViewById(R.id.checkbox_option3_question2)
        checkBoxQ2Option4 = findViewById(R.id.checkbox_option4_question2)

        val submitButton: Button = findViewById(R.id.submit_button)
        submitButton.setOnClickListener {
            calculateScore()
        }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener {
            resetQuiz()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculateScore() {
        var score = 0
        if (radioGroupQ1.checkedRadioButtonId == R.id.option1_question1) {
            score += 50
        }
        if (checkBoxQ2Option1.isChecked) score += 25.toInt()
        if (checkBoxQ2Option2.isChecked) score += 25.toInt()
        if (checkBoxQ2Option3.isChecked && score>0) {
            score -= 25.toInt()
        }
        if (checkBoxQ2Option4.isChecked && score>0) {
            score -= 25.toInt()
        }

        val currentDateTime = ZonedDateTime.now(ZoneId.systemDefault())

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val formattedDateTime = currentDateTime.format(formatter)

        AlertDialog.Builder(this)
            .setTitle("Quiz Results")
            .setMessage("Congratulations! You submitted on $formattedDateTime, you achieved ${score}%")
            .setPositiveButton("OK", null)
            .show()
    }

    private fun resetQuiz() {
        radioGroupQ1.clearCheck()
        checkBoxQ2Option1.isChecked = false
        checkBoxQ2Option2.isChecked = false
        checkBoxQ2Option3.isChecked = false
        checkBoxQ2Option4.isChecked = false
    }
}