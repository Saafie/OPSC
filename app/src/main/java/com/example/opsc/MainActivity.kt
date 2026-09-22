package com.example.opsc

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText


class MainActivity : ComponentActivity() {
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val forgotPassword = findViewById<TextView>(R.id.textView4)
        val loginButtonNav =findViewById<Button>(R.id.loginbutton)
        val signUpText = findViewById<TextView>(R.id.textView7)
         passwordInput = findViewById<EditText>(R.id.editTextTextPassword)
         emailInput = findViewById<EditText>(R.id.editTextTextEmailAddress)


        //Ensures the forgot password is underlined
        val rawText = getString(R.string.forgot_password)
        val underlineSpannable = SpannableString(rawText).apply{
            setSpan(UnderlineSpan(),0,length,0)
        }
        forgotPassword.text = underlineSpannable

        val signUpRawText = getString(R.string.signUp_link)
        val signUpUnderlineSpannable = SpannableString(signUpRawText).apply{
            setSpan(UnderlineSpan(),0,length,0)
        }
        signUpText.text = signUpUnderlineSpannable


        //when the forgot password is clicked
        forgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()

        }

        //signUp link to signup section
        signUpText.setOnClickListener {
            val intent = Intent(this, signUpSection::class.java).apply{
                putExtra("USER_EMAIL", emailInput.text.toString().trim())
            }
            startActivity(intent)
        }

        //Logs in when the login button is pressed
        loginButtonNav.setOnClickListener {
            attemptLogin()
        }

        passwordInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE){
               attemptLogin()
                true}
            else {
                false
            }
        }

        //This is checked if enter has been pressed
        passwordInput.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
               attemptLogin()
                true}
            else {
                false
            }
        }
    }


    private fun attemptLogin(){
        val email = emailInput.text.toString().trim()
        val password = passwordInput.text.toString()

        if(email.isEmpty()) {
            emailInput.error = "Please enter your email"
            emailInput.requestFocus()
            return
        }

        if (password.isEmpty()){
            passwordInput.error = "Please enter your password"
            passwordInput.requestFocus()
            return
        }
        //Authenticates it against the Rest API
        authenticateWithApi(email, password)
    }

    private fun authenticateWithApi(email: String, password: String){
        Toast.makeText(this, "Logging in", Toast.LENGTH_SHORT ).show()
        navigateToHome()
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish() // This will close the main activity
    }
}