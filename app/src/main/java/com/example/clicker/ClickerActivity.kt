package com.example.clicker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clicker.databinding.ActivityClickerBinding

class ClickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityClickerBinding
        binding = ActivityClickerBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.clickerBackground) { v, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.displayCutout()
            )
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        val back_id = intent.getIntExtra("BACK_ID", R.drawable.background_just_cookie)
        val image_id = intent.getIntExtra("IMAGE_ID", R.drawable.just_cookie)

        binding.clickerBackground.setBackgroundResource(back_id)
        binding.cookieImage.setImageResource(image_id)
        val auth = AuthManager(this)
        binding.logout.setOnClickListener {
            auth.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}