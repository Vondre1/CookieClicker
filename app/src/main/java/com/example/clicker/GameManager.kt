package com.example.clicker

import android.content.Context

class GameManager(val context: Context) {
    private val prefs = context.getSharedPreferences("game_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_CLICS_PREFIX = "clicks_"
    }

    private fun clicksKey(login: String): String{
        return KEY_CLICS_PREFIX + login
    }

    fun getClicks(login: String): Long{
        val key = clicksKey(login)
        return prefs.getLong(key, 0L)
    }

    fun addClick(clicks: Long, login: String){
        val key = clicksKey(login)
        val current = prefs.getLong(key ,0L)
        prefs.edit()
            .putLong(key, current + clicks)
            .apply()
    }
}
