package com.example.opsc

import android.os.Bundle
import android.text.Html
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import android.view.KeyEvent
import android.widget.EditText
import androidx.core.text.HtmlCompat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    val forgotPassword = findViewById<TextView>(R.id.textView4)
     forgotPassword.text = HtmlCompat.fromHtml(getString(R.string.forgot_password), HtmlCompat.FROM_HTML_MODE_LEGACY)
    val passwordInput = findViewById<EditText>(R.id.editTextTextPassword)

    forgotPassword.setOnClickListener {
        Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()

    }

        passwordInput.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                val enterPassword = passwordInput.text.toString()

                Toast.makeText(this, "Enter pressed", Toast.LENGTH_SHORT).show()
                true}
            else {
                false
            }
        }
    }

}