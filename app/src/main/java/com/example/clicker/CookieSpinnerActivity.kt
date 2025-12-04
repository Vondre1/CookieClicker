package com.example.clicker

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

        val cookieSpinner: Spinner = findViewById(R.id.cookie_spinner)
        val cookieImage: ImageView = findViewById(R.id.cookieImage)
        val cookieName: EditText = findViewById(R.id.cookieName)
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

        val adapter = CookieAdapter(this, cookies)
        cookieSpinner.adapter = adapter

        cookieSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedCookie = cookies[position]
                cookieImage.setImageResource(selectedCookie.imageId)
                val selectedCookieName = selectedCookie.name
                back.setBackgroundResource(selectedCookie.backId)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

//        button.setOnClickListener {
//            val cookieUserName = cookieName.text.toString().trim()
//
//            if (cookieUserName.isEmpty()){
//                cookieUserName = selectedCookieName
//            }
//        }
    }
}