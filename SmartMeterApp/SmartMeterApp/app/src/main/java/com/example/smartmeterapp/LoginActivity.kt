package com.example.smartmeterapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        // Initialize views
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val loginButton = findViewById<TextView>(R.id.@drawable/ic_login_button)
        val registerText = findViewById<TextView>(R.id.registerText) // Update ID for the register text, if needed

        // Set up login button click listener
        loginButton.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (validateInput(email, password)) {
                // Navigate to MainActivity
                navigateToMainActivity()
            } else {
                // Show error toast
                Toast.makeText(this, "Please enter valid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        // Set up register navigation (if applicable)
        registerText.setOnClickListener {
            Toast.makeText(this, "Navigate to Register Screen (to be implemented)", Toast.LENGTH_SHORT).show()
            // Uncomment and modify the following line if you have a RegisterActivity
            // startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    /**
     * Validates the user input.
     */
    private fun validateInput(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }

    /**
     * Navigates to the MainActivity after a successful login.
     */
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
