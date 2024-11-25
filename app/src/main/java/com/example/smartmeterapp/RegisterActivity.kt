package com.example.smartmeterapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_register)

        // Initialize views
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextMobile = findViewById<EditText>(R.id.editTextMobile)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val registerButton = findViewById<ImageView>(R.id.@drawable/ic_login_button)
        val loginText = findViewById<TextView>(R.id.loginText)

        // Set up register button click listener
        registerButton.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val mobile = editTextMobile.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (validateInput(name, mobile, email, password)) {
                // Perform registration logic (e.g., save user info or navigate)
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                navigateToLogin()
            } else {
                // Show error toast
                Toast.makeText(this, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigate back to login screen
        loginText.setOnClickListener {
            navigateToLogin()
        }
    }

    /**
     * Validates the user input.
     */
    private fun validateInput(name: String, mobile: String, email: String, password: String): Boolean {
        return name.isNotEmpty() &&
                mobile.isNotEmpty() &&
                android.util.Patterns.PHONE.matcher(mobile).matches() &&
                email.isNotEmpty() &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                password.isNotEmpty()
    }

    /**
     * Navigates to the LoginActivity.
     */
    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
