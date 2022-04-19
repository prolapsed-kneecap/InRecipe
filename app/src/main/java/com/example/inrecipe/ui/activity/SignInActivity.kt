package com.example.inrecipe.ui.activity

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.inrecipe.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        supportActionBar?.title = "Регистрация"

        val emailEditText = findViewById<TextInputEditText>(R.id.emailEditText_register)
        val passwordEditText = findViewById<TextInputEditText>(R.id.passwordEditText_register)
        val registerButton = findViewById<MaterialButton>(R.id.LoginBtn_register)

        val mAuth = FirebaseAuth.getInstance()

        registerButton.setOnClickListener {
            if (emailEditText.text != null && passwordEditText.text != null) {
                if (emailEditText.text!!.isEmpty() or passwordEditText.text!!.isEmpty()) {
                    Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
                } else {
                    mAuth.createUserWithEmailAndPassword(
                        emailEditText.text.toString(),
                        passwordEditText.text.toString()
                    )
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Log.d(ContentValues.TAG, "signInWithEmail:success")
                                val intent = Intent(this, AuthActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                                Toast.makeText(
                                    baseContext, "Возникла ошибка",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}