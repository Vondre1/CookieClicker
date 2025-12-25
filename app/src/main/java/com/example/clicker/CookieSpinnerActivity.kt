package com.example.clicker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class CookieSpinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cookie_spinner)

        val cookieChoose = AuthManager(this)

        val cookieSpinner: Spinner = findViewById(R.id.cookie_spinner)
        val cookieImage: ImageView = findViewById(R.id.cookieImage)
        val cookieNameInput: EditText = findViewById(R.id.cookieNameInput)
        val back: ConstraintLayout = findViewById(R.id.background)
        val button: Button = findViewById(R.id.start)

        val cookies = listOf(
            Cookie(
                "Печенье",
                R.drawable.just_cookie,
                R.drawable.background_just_cookie
            ),
            Cookie(
                "Шоколадное печенье",
                R.drawable.chocolate_cookie,
                R.drawable.background_chocolad
            ),
            Cookie(
                "Песочное печенье",
                R.drawable.pesochnoe_cookie,
                R.drawable.background_pesochnoe
            )
        )

        var selectedCookie = cookies[0]
        val adapter = CookieAdapter(this, cookies)
        cookieSpinner.adapter = adapter

        cookieSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedCookie = cookies[position]
                cookieImage.setImageResource(selectedCookie.imageId)
                back.setBackgroundResource(selectedCookie.backId)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        button.setOnClickListener {
            var finalCookieName = cookieNameInput.text.toString().trim()

            if (finalCookieName.isEmpty()){
                finalCookieName = selectedCookie.name ?: "Печенье"
            }
            val intent = Intent(this, ClickerActivity::class.java)
            intent.putExtra("NAME", selectedCookie.name)
            intent.putExtra("BACK_ID", selectedCookie.backId)
            intent.putExtra("IMAGE_ID", selectedCookie.imageId)
            intent.putExtra("finalCookieName", finalCookieName)
            startActivity(intent)
            finish()
        }
    }
}