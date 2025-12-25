package com.example.clicker

import android.content.Context

class GameManager(val context: Context) {
    private val prefs = context.getSharedPreferences("game_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_CLICS_PREFIX = "clicks_"
    }

    private fun clicksKey(coockieType: String, username: String, coockieName: String): String{
        return KEY_CLICS_PREFIX + coockieType + username
    }

    fun getClicks(coockieType: String, username: String, coockieName: String): Long{
        val key = clicksKey(coockieType, username, coockieName)
        return prefs.getLong(key, 0L)
    }

    fun addClick(clicks: Long, coockieType: String, username: String, coockieName: String){
        val key = clicksKey(coockieType, username, coockieName)
        val current = prefs.getLong(key ,0L)
        prefs.edit()
            .putLong(key, current + clicks)
            .apply()
    }
}
