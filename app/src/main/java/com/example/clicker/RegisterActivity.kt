package com.example.clicker

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.clicker.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        lateinit var binding: ActivityRegisterBinding
        binding = ActivityRegisterBinding.inflate(layoutInflater)

        val auth = AuthManager(this)
        if (auth.isLoggedIn()) {
            startActivity(Intent(this, ClickerActivity::class.java))
            finish()
            return
        }

        binding.linkToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.buttonReg.setOnClickListener {
            val login = binding.userLoginReg.text.toString().trim()
            val pass = binding.userPassReg.text.toString().trim()


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