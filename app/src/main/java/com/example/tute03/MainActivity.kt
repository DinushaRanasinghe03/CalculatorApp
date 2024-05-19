package com.example.tute03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.tute03.Models.Calculator

class MainActivity : AppCompatActivity() {

    lateinit var edtNumber1: EditText
    lateinit var edtNumber2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber1 = findViewById(R.id.editTextText)
        edtNumber2 = findViewById(R.id.editTextText2)
    }

    fun buttonClick(v: View) {
        val num1 = edtNumber1.text.toString().toDoubleOrNull()
        val num2 = edtNumber2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_LONG).show()
            return
        }

        val calculator = Calculator(num1, num2)
        var ans = 0.0

        when (v.id) {
            R.id.button -> ans = calculator.add()
            R.id.button2 -> ans = calculator.subtract()
            R.id.button3 -> ans = calculator.multiply()
            R.id.button4 -> ans = calculator.divide()
        }

        // Display the result in a Toast message
        Toast.makeText(this, "Answer = $ans", Toast.LENGTH_LONG).show()

        // Pass the calculated answer to DisplayActivity
        val intent = Intent(this, DisplayActivity::class.java)
        intent.putExtra("answer", ans)
        startActivity(intent)
        finish()
    }
}
