package com.example.clicker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val auth = AuthManager(this)
        if (auth.isLoggedIn()) {
            startActivity(Intent(this, ClickerActivity::class.java))
            finish()
            return
        }
        val userLogin: EditText = findViewById(R.id.user_login_reg)
        val userPass: EditText = findViewById(R.id.user_pass_reg)
        val button: Button = findViewById(R.id.button_reg)
        val linkToLogin: TextView = findViewById(R.id.link_to_login)

        linkToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()


            if (login.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            } else{
                auth.register(login, pass)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ClickerActivity::class.java))
                finish()
            }
        }
    }
}