package com.example.clicker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CookieAdapter(
    context: Context,
    private val cookies: List<Cookie>
) : ArrayAdapter<Cookie>(context, 0, cookies) {  // ✅ ИСПРАВЛЕНО: Cookie вместо String

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createCookieView(position, convertView, parent)  // ✅ ИСПРАВЛЕНО: вызываем createCookieView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createCookieView(position, convertView, parent)  // ✅ ИСПРАВЛЕНО: вызываем createCookieView
    }

    private fun createCookieView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_cookie_spinner, parent, false)  // ✅ ИСПРАВЛЕНО: item_cookie_spinner вместо activity_cookie_spinner

        val image: ImageView = view.findViewById(R.id.itemCookieImage)  // ✅ ИСПРАВЛЕНО: itemCookieImage
        val text: TextView = view.findViewById(R.id.itemCookieText)    // ✅ ИСПРАВЛЕНО: itemCookieText вместо cookie_spinner

        val cookie = cookies[position]  // ✅ ДОБАВЛЕНО: берём печенье

        image.setImageResource(cookie.imageId)  // ✅ ДОБАВЛЕНО: ставим картинку
        text.text = cookie.name                    // ✅ ДОБАВЛЕНО: ставим имя

        return view  // ✅ ДОБАВЛЕНО: возвращаем view
    }
}
