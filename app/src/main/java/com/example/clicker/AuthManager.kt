package com.example.clicker

import android.content.Context

class AuthManager(val context: Context) {
    private val prefs = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun register(login: String, pass: String) {
        prefs.edit()
            .putString("login", login)
            .putString("pass", pass)
            .putBoolean("is_logged_in", true)
            .apply()
    }

    fun isRegistred(): Boolean {
        val savedLogin = prefs.getString("login", null)
        val savedPass = prefs.getString("pass", null)
        return !savedLogin.isNullOrEmpty() && !savedPass.isNullOrEmpty()
    }

    fun login(login: String, pass: String): Boolean {
        val savedLogin = prefs.getString("login", null)
        val savedPass = prefs.getString("pass", null)

        val success = login == savedLogin && pass == savedPass
        if (success) {
            prefs.edit()
                .putBoolean("is_logged_in", true)
                .apply()
        }
        return success
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("is_logged_in", false)
    }

    fun logout() {
        prefs.edit()
            .putBoolean("is_logged_in", false)
            .apply()
    }
}