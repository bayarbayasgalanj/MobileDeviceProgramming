package com.miu.lab3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop

class MainActivity : AppCompatActivity() {
    private lateinit var tableLayout: TableLayout
    private lateinit var buttonAddRow: Button
    private lateinit var binding: Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tableLayout = findViewById(R.id.tableLayout)
        buttonAddRow = findViewById(R.id.buttonAdd)

        buttonAddRow.setOnClickListener {
            addRowToTable()
        }
    }
    private fun addRowToTable() {
        var editTextVersion = findViewById<EditText>(R.id.textVersion)
        val versionText = editTextVersion.text.toString()
        if (versionText.isEmpty()) {
            editTextVersion.error = "This field is required"
        }
        var editCodeName = findViewById<EditText>(R.id.textCodeName)
        val CodeNameText = editCodeName.text.toString()
        if (versionText.isEmpty() or CodeNameText.isEmpty()) {
            if (CodeNameText.isEmpty()){editCodeName.error = "This field is required"}
            if (versionText.isEmpty()){editTextVersion.error = "This field is required"}
        }else{
            val tableRow = TableRow(this).apply {
                setBackgroundColor(Color.parseColor("#FF4182"))

                val dpValue = 10 * resources.displayMetrics.density
                val paddingTopValue = dpValue.toInt()
                setPadding(0, paddingTopValue, 0, 0)  // left, top, right, bottom
            }

            val textView = TextView(this).apply {
                text = versionText
            }

            tableRow.addView(textView)

            val textView2 = TextView(this).apply {
                text = CodeNameText
            }

            tableRow.addView(textView2)

            tableLayout.addView(tableRow)
        }

    }

}