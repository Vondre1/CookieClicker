package com.example.clicker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class ClickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_clicker)

        val back = findViewById<ConstraintLayout>(R.id.clicker_background)

        ViewCompat.setOnApplyWindowInsetsListener(back) { v, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.displayCutout()
            )
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        val cookieName = intent.getStringExtra("NAME")
        val back_id = intent.getIntExtra("BACK_ID", R.drawable.background_just_cookie)
        val image_id = intent.getIntExtra("IMAGE_ID", R.drawable.just_cookie)
        val finalCookieName = intent.getStringExtra("finalCookieName")

        back.setBackgroundResource(back_id)

        val cookieImage: ImageView = findViewById(R.id.cookieImage)
        cookieImage.setImageResource(image_id)

        

        val logout: ImageView = findViewById(R.id.logout)
        val auth = AuthManager(this)
        logout.setOnClickListener {
            auth.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}