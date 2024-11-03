package com.example.myapplication00

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edt: EditText = findViewById(R.id.edt)
        val edt2: TextView = findViewById(R.id.textView)
        val btn = findViewById<Button>(R.id.btn)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)

        btn.setOnClickListener {
            val enteredText = edt.text
            edt2.text = "" + increaseNumber()
            // Toast.makeText(this, "Hello " + enteredText, Toast.LENGTH_LONG).show()
        }

        btn2.setOnClickListener {
            val enteredText = edt.text
            Toast.makeText(this, "Hello $enteredText", Toast.LENGTH_LONG).show()
        }

        btn3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View): Unit {
                val intent = Intent(this@MainActivity, Page2::class.java)
                startActivity(intent)
            }
        })
    }

    fun increaseNumber(): Int {
        counter++
        return counter
    }
}
