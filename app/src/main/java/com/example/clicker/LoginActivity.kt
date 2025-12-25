package com.example.clicker

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.clicker.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        lateinit var binding: ActivityLoginBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)

        val auth = AuthManager(this)
        if (auth.isLoggedIn()) {
            startActivity(Intent(this, ClickerActivity::class.java))
            finish()
        }

        binding.linkToReg.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.buttonAuth.setOnClickListener {
            val login = binding.userLoginAuth.text.toString().trim()
            val pass = binding.userPassAuth.text.toString().trim()


            if (login.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            } else if (auth.login(login, pass)) {
                startActivity(Intent(this, ClickerActivity::class.java))
                finish()
            } else{
                Toast.makeText(this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}