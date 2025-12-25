package com.example.clicker

import android.content.Context

class GameManager(val context: Context) {
    private val prefs = context.getSharedPreferences("game_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_CLICS_PREFIX = "clicks_"
    }

    private fun clicksKey(username: String): String{
        return KEY_CLICS_PREFIX + username
    }

    fun getClicks(username: String): Long{
        val key = clicksKey(username)
        return prefs.getLong(key, 0L)
    }

    fun addClick(clicks: Long, username: String){
        val key = clicksKey(username)
        val current = prefs.getLong(key ,0L)
        prefs.edit()
            .putLong(key, current + clicks)
            .apply()
    }
}
