package com.example.opsc

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class signUpDetailsActivity : AppCompatActivity() {
    private lateinit var emailDisplay: EditText
    private lateinit var nameInput:EditText
    private lateinit var surnameInput:EditText
    private lateinit var usernameInput:EditText
    private lateinit var passwordInput: EditText
    private lateinit var birthDateInput:EditText
    private lateinit var confirmedPasswordInput:EditText
    private lateinit var loginButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_details)
        emailDisplay = findViewById(R.id.textEmailDetail)
        nameInput = findViewById(R.id.textNameDetail)
        surnameInput = findViewById(R.id.textSurnameDetail)
        birthDateInput = findViewById(R.id.textBirthDate)
        usernameInput = findViewById(R.id.textUserName)
        passwordInput = findViewById(R.id.textPasswordDetails)
        confirmedPasswordInput = findViewById(R.id.textConfirmPassword)
        loginButton = findViewById(R.id.signUpbutton)

        val userEmail = intent.getStringExtra("USER_EMAIL")
        emailDisplay.setText(userEmail)

        loginButton.setOnClickListener {
            validateAndSubmit(userEmail ?: "")
        }
    }

    private fun showDate(){
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDate = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            { _, year,monthOfYear, dayOfMonth ->
            val formattedDate = String.format("%04d-%02d-%02d", year, monthOfYear + 1, dayOfMonth)
                birthDateInput.setText(formattedDate)
                birthDateInput.error =null},
            currentYear - 18,
            currentMonth,
            currentDate)

        datePickerDialog.datePicker.maxDate = calendar.timeInMillis
        datePickerDialog.show()


    }

        private fun validateAndSubmit(email:String){
            val name =nameInput.text.toString().trim()
            val surname =surnameInput.text.toString().trim()
            val username =usernameInput.text.toString().trim()
            val dateBirth =birthDateInput.text.toString()
            val password =passwordInput.text.toString()
            val confirmPassword =confirmedPasswordInput.text.toString()


     if (name.isEmpty()){
         nameInput.error = "Please enter your name"
         nameInput.requestFocus()
         return
     }

            if (name.isEmpty()){
                nameInput.error = "Please enter your name"
                nameInput.requestFocus()
                return
            }
            if (surname.isEmpty()){
                surnameInput.error = "Please enter your surname"
                surnameInput.requestFocus()
                return
            }
            if (username.isEmpty()){
                usernameInput.error = "Please enter your username"
                usernameInput.requestFocus()
                return
            }
            if (dateBirth.isEmpty()){
                birthDateInput.error = "Username need more than 3 characters"
                birthDateInput.requestFocus()
                return
            }
            if (username.length<3){
                usernameInput.error = "Username need more than 3 characters"
                usernameInput.requestFocus()
                return
            }
            if (password.length<6){
                passwordInput.error = "Password need more than 6 characters"
                passwordInput.requestFocus()
                return
            }
            if (password != confirmPassword){
                confirmedPasswordInput.error = "Password does not match"
                confirmedPasswordInput.requestFocus()
                return
            }

            Toast.makeText(this, "Welcome, @$username!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java).apply{
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK}
            startActivity(intent)
            finish()
            }
    }


