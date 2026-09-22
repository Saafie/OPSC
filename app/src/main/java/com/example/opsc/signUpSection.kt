package com.example.opsc

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class signUpSection : AppCompatActivity() {
    private lateinit var emailInput: EditText
    private lateinit var signUpButton:Button
    private lateinit var googleLoginButton:Button
    private lateinit var loginText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        emailInput = findViewById<EditText>(R.id.signUpEmailAddress)
        signUpButton =findViewById<Button>(R.id.signUpbutton)
        googleLoginButton = findViewById<Button>(R.id.button2)
        loginText = findViewById<TextView>(R.id.textView4)

        signUpButton.setOnClickListener {
            val email= emailInput.text.toString().trim()
            if (email.isEmpty()){
                emailInput.error = "Please enter your email"
            emailInput.requestFocus()
            return@setOnClickListener}

            val intent = Intent(this, signUpDetailsActivity::class.java).apply{
                putExtra("USER_EMAIL", email)
            }
            startActivity(intent)
        }


    loginText.setOnClickListener {
        val intentMain = Intent(this, MainActivity::class.java)
        startActivity(intentMain)
    }

    googleLoginButton.setOnClickListener {
        val intentHome = Intent(this, HomeActivity::class.java)
        startActivity(intentHome)
    }
}

}

